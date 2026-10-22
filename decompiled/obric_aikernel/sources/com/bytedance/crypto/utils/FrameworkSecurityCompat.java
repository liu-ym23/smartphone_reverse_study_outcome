package com.bytedance.crypto.utils;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.aiassistant.security.rot_provision.RotProvisionManager;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretDataManager;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSecurityCompat {
    private static final String AIASSISTANT_SECRET_DATA_MANAGER = "com.aiassistant.security.secretdata.SecretDataManager";
    private static final String OBric_SECRET_DATA_MANAGER = "com.obric.security.secretdata.SecretDataManager";
    private static final String TAG = "FrameworkSecurityCompat";
    private static volatile Impl sImpl;

    /* JADX INFO: renamed from: com.bytedance.crypto.utils.FrameworkSecurityCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AiassistantImpl implements Impl {
        private AiassistantImpl() {
        }

        public /* synthetic */ AiassistantImpl(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r10, Object r11, Bundle r12) {
            if ((r11 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            AddResult r13 = SecretDataManager.getInstance().addData(r10, (com.aiassistant.security.secretdata.SecretData) r11, r12);
            if (r13 != null) goto L9;
            return -1;
        L9:
            return r13.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r10, String r11, Bundle r12) {
            return SecretDataManager.getInstance().deleteData(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r10, String r11, Bundle r12) {
            return KeyManager.getInstance().deleteKey(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r10, String r11) {
            return KeyManager.getInstance().deleteSyncKey(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r10, String r11, Bundle r12) {
            return KeyManager.getInstance().generateKeyPair(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r10, String r11, Bundle r12) {
            return new AiassistantKmResult(KeyManager.getInstance().getCertificateChain(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r10, Bundle r11) {
            return KeyManager.getInstance().importKey(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r10, Bundle r11) {
            return KeyManager.getInstance().importKeyLegacy(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAgreement(r10, r11, r12, r13), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r10, String r11, Bundle r12) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAttestation(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.aiassistant.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r10, int r11, byte[] r12, byte[] r13, Bundle r14) {
            return PlatformKeyManager.getInstance().decrypt(r10, r11, r12, r13, r14);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r10, String r11, Bundle r12) {
            return new AiassistantSdQueryResult(SecretDataManager.getInstance().queryData(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r10, Bundle r11) {
            String r12 = RotProvisionManager.getInstance().checkState(r10, r11);
            if (r12 != null) goto L6;
            return "";
        L6:
            return r12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r10) {
            String r11 = ((com.aiassistant.security.secretdata.SecretData) r10).extInfo;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r10) {
            String r11 = ((com.aiassistant.security.secretdata.SecretData) r10).publicData;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r10) {
            String r11 = ((com.aiassistant.security.secretdata.SecretData) r10).searchInfo;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r10) {
            String r11 = ((com.aiassistant.security.secretdata.SecretData) r10).secretData;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r10, String r11) {
            ((com.aiassistant.security.secretdata.SecretData) r10).alias = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r10, String r11) {
            ((com.aiassistant.security.secretdata.SecretData) r10).extInfo = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r10, String r11) {
            ((com.aiassistant.security.secretdata.SecretData) r10).publicData = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r10, String r11) {
            ((com.aiassistant.security.secretdata.SecretData) r10).searchInfo = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r10, String r11) {
            ((com.aiassistant.security.secretdata.SecretData) r10).secretData = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r10, Object r11, Bundle r12) {
            if ((r11 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return SecretDataManager.getInstance().updateData(r10, (com.aiassistant.security.secretdata.SecretData) r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13) {
            return new AiassistantKmResult(KeyManager.getInstance().xcrypt(r10, r11, r12, r13), null);
        }
    }

    public static final class AiassistantKmResult implements KmResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final KeyManagerResult f1509m;

        private AiassistantKmResult(KeyManagerResult r10) {
            this.f1509m = r10;
        }

        public /* synthetic */ AiassistantKmResult(KeyManagerResult r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            KeyManagerResult r10 = this.f1509m;
            if (r10 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r10.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            KeyManagerResult r10 = this.f1509m;
            if (r10 != null) goto L6;
            return new byte[0];
        L6:
            return r10.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            KeyManagerResult r10 = this.f1509m;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getResultCode();
        }
    }

    public static final class AiassistantSdQueryResult implements SdQueryResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final QueryResult f1510m;

        private AiassistantSdQueryResult(QueryResult r10) {
            this.f1510m = r10;
        }

        public /* synthetic */ AiassistantSdQueryResult(QueryResult r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            QueryResult r10 = this.f1510m;
            if (r10 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r10.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            QueryResult r10 = this.f1510m;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getResultCode();
        }
    }

    public interface Impl {
        int addData(Context r10, Object r11, Bundle r12);

        String additionalData();

        String bundleKeyQueryMode();

        String challenge();

        int deleteData(Context r10, String r11, Bundle r12);

        int deleteKey(Context r10, String r11, Bundle r12);

        int deleteSyncKey(Context r10, String r11);

        String deviceHealthStatusRequired();

        String eccPrivateKey();

        String eccPublicKey();

        int generateKeyPair(Context r10, String r11, Bundle r12);

        KmResult getCertificateChain(Context r10, String r11, Bundle r12);

        int importKey(Context r10, Bundle r11);

        int importKeyLegacy(Context r10, Bundle r11);

        KmResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13);

        String keyAlgo();

        int keyAlgorithmEcc();

        String keyAlias();

        KmResult keyAttestation(Context r10, String r11, Bundle r12);

        String keyLen();

        String keyPurpose();

        int kmSuccess();

        Object newSecretData();

        int platformIvLen();

        byte[] platformKeyDecrypt(Context r10, int r11, byte[] r12, byte[] r13, Bundle r14);

        int platformMagicNumLen();

        int platformSm8750();

        int platformVerLen();

        int preciseQueryAndDecrypt();

        int purposeAgreeKey();

        int purposeAttestKey();

        SdQueryResult queryData(Context r10, String r11, Bundle r12);

        String rotCheckState(Context r10, Bundle r11);

        String sdGetExtInfo(Object r10);

        String sdGetPublicData(Object r10);

        String sdGetSearchInfo(Object r10);

        String sdGetSecretData(Object r10);

        void sdSetAlias(Object r10, String r11);

        void sdSetExtInfo(Object r10, String r11);

        void sdSetPublicData(Object r10, String r11);

        void sdSetSearchInfo(Object r10, String r11);

        void sdSetSecretData(Object r10, String r11);

        int secretDataNotFound();

        int secretSuccess();

        int updateData(Context r10, Object r11, Bundle r12);

        String wrappedKeyData();

        KmResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13);
    }

    public static final class KeyManagerConst {
        public KeyManagerConst() {
        }

        public static String ADDITIONAL_DATA() {
            return FrameworkSecurityCompat.access$900().additionalData();
        L4:
            return "ADDITIONAL_DATA";
        }

        public static String CHALLENGE() {
            return FrameworkSecurityCompat.access$900().challenge();
        L4:
            return "CHALLENGE";
        }

        public static String DEVICE_HEALTH_STATUS_REQUIRED() {
            return FrameworkSecurityCompat.access$900().deviceHealthStatusRequired();
        L4:
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        public static String ECC_PRIVATE_KEY() {
            return FrameworkSecurityCompat.access$900().eccPrivateKey();
        L4:
            return "ECC_PRIVATE_KEY";
        }

        public static String ECC_PUBLIC_KEY() {
            return FrameworkSecurityCompat.access$900().eccPublicKey();
        L4:
            return "ECC_PUBLIC_KEY";
        }

        public static String KEY_ALGO() {
            return FrameworkSecurityCompat.access$900().keyAlgo();
        L4:
            return "KEY_ALGO";
        }

        public static int KEY_ALGORITHM_ECC() {
            return FrameworkSecurityCompat.access$900().keyAlgorithmEcc();
        L4:
            return -1;
        }

        public static String KEY_ALIAS() {
            return FrameworkSecurityCompat.access$900().keyAlias();
        L4:
            return "KEY_ALIAS";
        }

        public static String KEY_LEN() {
            return FrameworkSecurityCompat.access$900().keyLen();
        L4:
            return "KEY_LEN";
        }

        public static String KEY_PURPOSE() {
            return FrameworkSecurityCompat.access$900().keyPurpose();
        L4:
            return "KEY_PURPOSE";
        }

        public static int PURPOSE_AGREE_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAgreeKey();
        L4:
            return 0;
        }

        public static int PURPOSE_ATTEST_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAttestKey();
        L4:
            return 0;
        }

        public static String WRAPPED_KEY_DATA() {
            return FrameworkSecurityCompat.access$900().wrappedKeyData();
        L4:
            return "WRAPPED_KEY_DATA";
        }
    }

    public static final class KeyManagerErrorCode {
        public KeyManagerErrorCode() {
        }

        public static int KM_SUCCESS() {
            return FrameworkSecurityCompat.access$900().kmSuccess();
        L4:
            return 0;
        }
    }

    public interface KmResult {
        List<Certificate> getCertChain();

        byte[] getOutData();

        int getResultCode();
    }

    public static final class NoopImpl implements Impl {
        private NoopImpl() {
        }

        public /* synthetic */ NoopImpl(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r10, Object r11, Bundle r12) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "ADDITIONAL_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "BUNDLE_KEY_QUERY_MODE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "CHALLENGE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r10, String r11, Bundle r12) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r10, String r11, Bundle r12) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r10, String r11) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ECC_PRIVATE_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ECC_PUBLIC_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r10, String r11, Bundle r12) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r10, String r11, Bundle r12) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r10, Bundle r11) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r10, Bundle r11) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "KEY_ALGO";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "KEY_ALIAS";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r10, String r11, Bundle r12) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "KEY_LEN";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "KEY_PURPOSE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r10, int r11, byte[] r12, byte[] r13, Bundle r14) {
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r10, String r11, Bundle r12) {
            return new NoopSdQueryResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r10, Bundle r11) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r10) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r10) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r10) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r10) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r10, String r11) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r10, String r11) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r10, String r11) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r10, String r11) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r10, String r11) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r10, Object r11, Bundle r12) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "WRAPPED_KEY_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13) {
            return new NoopKmResult(null);
        }
    }

    public static final class NoopKmResult implements KmResult {
        private NoopKmResult() {
        }

        public /* synthetic */ NoopKmResult(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            return new byte[0];
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class NoopSdQueryResult implements SdQueryResult {
        private NoopSdQueryResult() {
        }

        public /* synthetic */ NoopSdQueryResult(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class ObricImpl implements Impl {
        private ObricImpl() {
        }

        public /* synthetic */ ObricImpl(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r10, Object r11, Bundle r12) {
            if ((r11 instanceof com.obric.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            com.obric.security.secretdata.AddResult r13 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r10, (com.obric.security.secretdata.SecretData) r11, r12);
            if (r13 != null) goto L9;
            return -1;
        L9:
            return r13.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r10, String r11, Bundle r12) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r10, String r11, Bundle r12) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r10, String r11) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteSyncKey(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r10, String r11, Bundle r12) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r10, r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r10, String r11, Bundle r12) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().getCertificateChain(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r10, Bundle r11) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKey(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r10, Bundle r11) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKeyLegacy(r10, r11);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAgreement(r10, r11, r12, r13), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r10, String r11, Bundle r12) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.obric.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r10, int r11, byte[] r12, byte[] r13, Bundle r14) {
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().decrypt(r10, r11, r12, r13, r14);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r10, String r11, Bundle r12) {
            return new ObricSdQueryResult(com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r10, r11, r12), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r10, Bundle r11) {
            String r12 = com.obric.security.rot_provision.RotProvisionManager.getInstance().checkState(r10, r11);
            if (r12 != null) goto L6;
            return "";
        L6:
            return r12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r10) {
            String r11 = ((com.obric.security.secretdata.SecretData) r10).extInfo;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r10) {
            String r11 = ((com.obric.security.secretdata.SecretData) r10).publicData;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r10) {
            String r11 = ((com.obric.security.secretdata.SecretData) r10).searchInfo;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r10) {
            String r11 = ((com.obric.security.secretdata.SecretData) r10).secretData;
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r10, String r11) {
            ((com.obric.security.secretdata.SecretData) r10).alias = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r10, String r11) {
            ((com.obric.security.secretdata.SecretData) r10).extInfo = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r10, String r11) {
            ((com.obric.security.secretdata.SecretData) r10).publicData = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r10, String r11) {
            ((com.obric.security.secretdata.SecretData) r10).searchInfo = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r10, String r11) {
            ((com.obric.security.secretdata.SecretData) r10).secretData = r11;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r10, Object r11, Bundle r12) {
            if ((r11 instanceof com.obric.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return com.obric.security.secretdata.SecretDataManager.getInstance().updateData(r10, (com.obric.security.secretdata.SecretData) r11, r12);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().xcrypt(r10, r11, r12, r13), null);
        }
    }

    public static final class ObricKmResult implements KmResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final com.obric.security.keymanager.KeyManagerResult f1511m;

        private ObricKmResult(com.obric.security.keymanager.KeyManagerResult r10) {
            this.f1511m = r10;
        }

        public /* synthetic */ ObricKmResult(com.obric.security.keymanager.KeyManagerResult r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            com.obric.security.keymanager.KeyManagerResult r10 = this.f1511m;
            if (r10 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r10.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            com.obric.security.keymanager.KeyManagerResult r10 = this.f1511m;
            if (r10 != null) goto L6;
            return new byte[0];
        L6:
            return r10.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            com.obric.security.keymanager.KeyManagerResult r10 = this.f1511m;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getResultCode();
        }
    }

    public static final class ObricSdQueryResult implements SdQueryResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final com.obric.security.secretdata.QueryResult f1512m;

        private ObricSdQueryResult(com.obric.security.secretdata.QueryResult r10) {
            this.f1512m = r10;
        }

        public /* synthetic */ ObricSdQueryResult(com.obric.security.secretdata.QueryResult r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            com.obric.security.secretdata.QueryResult r10 = this.f1512m;
            if (r10 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r10.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            com.obric.security.secretdata.QueryResult r10 = this.f1512m;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getResultCode();
        }
    }

    public static final class PlatformKeyConst {
        public PlatformKeyConst() {
        }

        public static int IV_LEN() {
            return FrameworkSecurityCompat.access$900().platformIvLen();
        L4:
            return 0;
        }

        public static int MAGIC_NUM_LEN() {
            return FrameworkSecurityCompat.access$900().platformMagicNumLen();
        L4:
            return 0;
        }

        public static int PLATFORM_SM8750() {
            return FrameworkSecurityCompat.access$900().platformSm8750();
        L4:
            return 0;
        }

        public static int PLATFORM_VER_LEN() {
            return FrameworkSecurityCompat.access$900().platformVerLen();
        L4:
            return 0;
        }
    }

    public static final class QueryMode {
        public QueryMode() {
        }

        public static int PRECISE_QUERY_AND_DECRYPT() {
            return FrameworkSecurityCompat.access$900().preciseQueryAndDecrypt();
        L4:
            return 0;
        }
    }

    public interface SdQueryResult {
        List<?> getDataList();

        int getResultCode();
    }

    public static final class SecretConst {
        public SecretConst() {
        }

        public static String BUNDLE_KEY_QUERY_MODE() {
            return FrameworkSecurityCompat.access$900().bundleKeyQueryMode();
        L4:
            return "BUNDLE_KEY_QUERY_MODE";
        }
    }

    public static final class SecretData {
        public SecretData() {
        }

        public static String getExtInfo(Object r10) {
            if (r10 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetExtInfo(r10);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getExtInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getPublicData(Object r10) {
            if (r10 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetPublicData(r10);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getPublicData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSearchInfo(Object r10) {
            if (r10 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSearchInfo(r10);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSearchInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSecretData(Object r10) {
            if (r10 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSecretData(r10);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSecretData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static Object newInstance() {
            return FrameworkSecurityCompat.access$900().newSecretData();
        L4:
            return null;
        }

        public static void setAlias(Object r10, String r11) {
            if (r10 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetAlias(r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setAlias failed: " + th.getMessage());
            return;
        }

        public static void setExtInfo(Object r10, String r11) {
            if (r10 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetExtInfo(r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setExtInfo failed: " + th.getMessage());
            return;
        }

        public static void setPublicData(Object r10, String r11) {
            if (r10 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetPublicData(r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setPublicData failed: " + th.getMessage());
            return;
        }

        public static void setSearchInfo(Object r10, String r11) {
            if (r10 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSearchInfo(r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSearchInfo failed: " + th.getMessage());
            return;
        }

        public static void setSecretData(Object r10, String r11) {
            if (r10 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSecretData(r10, r11);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSecretData failed: " + th.getMessage());
            return;
        }
    }

    public static final class SecretErrorCode {
        public SecretErrorCode() {
        }

        public static int DATA_NOT_FOUNT() {
            return FrameworkSecurityCompat.access$900().secretDataNotFound();
        L4:
            return -1;
        }

        public static int SUCCESS() {
            return FrameworkSecurityCompat.access$900().secretSuccess();
        L4:
            return 0;
        }
    }

    private FrameworkSecurityCompat() {
    }

    public static /* synthetic */ Impl access$900() {
        return impl();
    }

    public static int addData(Context r10, Object r11, Bundle r12) {
        return impl().addData(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "addData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteData(Context r10, String r11, Bundle r12) {
        return impl().deleteData(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteKey(Context r10, String r11, Bundle r12) {
        return impl().deleteKey(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteKey failed: " + th.getMessage());
        return -1;
    }

    public static int deleteSyncKey(Context r10, String r11) {
        return impl().deleteSyncKey(r10, r11);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteSyncKey failed: " + th.getMessage());
        return -1;
    }

    public static int generateKeyPair(Context r10, String r11, Bundle r12) {
        return impl().generateKeyPair(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "generateKeyPair failed: " + th.getMessage());
        return -1;
    }

    public static KmResult getCertificateChain(Context r10, String r11, Bundle r12) {
        return impl().getCertificateChain(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "getCertificateChain failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    private static boolean hasClass(String r10) {
        Class.forName(r10, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        LogUtils.e(TAG, "Class not found:" + e);
        return false;
    }

    private static Impl impl() {
        if (sImpl == null) goto L7;
        return sImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sImpl == null) goto L13;
        Impl r10 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r10;
    L13:
        AnonymousClass1 r11 = null;
        if (hasClass(OBric_SECRET_DATA_MANAGER) == false) goto L17;
        sImpl = new ObricImpl(r11);     // Catch: Throwable -> L24
        String r12 = TAG;
        String r13 = "Resolved framework security package: com.obric.security";
    L19:
        LogUtils.i(r12, r13);     // Catch: Throwable -> L24
    L21:
        Impl r14 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r14;
    L17:
        if (hasClass(AIASSISTANT_SECRET_DATA_MANAGER) == false) goto L20;
        sImpl = new AiassistantImpl(r11);     // Catch: Throwable -> L24
        r12 = TAG;
        r13 = "Resolved framework security package: com.aiassistant.security";
        goto L19
    L20:
        sImpl = new NoopImpl(r11);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No framework security package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static int importKey(Context r10, Bundle r11) {
        return impl().importKey(r10, r11);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKey failed: " + th.getMessage());
        return -1;
    }

    public static int importKeyLegacy(Context r10, Bundle r11) {
        return impl().importKeyLegacy(r10, r11);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKeyLegacy failed: " + th.getMessage());
        return -1;
    }

    public static KmResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13) {
        return impl().keyAgreement(r10, r11, r12, r13);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAgreement failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static KmResult keyAttestation(Context r10, String r11, Bundle r12) {
        return impl().keyAttestation(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAttestation failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static byte[] platformKeyDecrypt(Context r10, int r11, byte[] r12, byte[] r13, Bundle r14) {
        return impl().platformKeyDecrypt(r10, r11, r12, r13, r14);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "platformKeyDecrypt failed: " + th.getMessage());
        return null;
    }

    public static SdQueryResult queryData(Context r10, String r11, Bundle r12) {
        return impl().queryData(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "queryData failed: " + th.getMessage());
        return new NoopSdQueryResult(null);
    }

    public static String rotCheckState(Context r10, Bundle r11) {
        return impl().rotCheckState(r10, r11);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "rotCheckState failed: " + th.getMessage());
        return "";
    }

    public static int updateData(Context r10, Object r11, Bundle r12) {
        return impl().updateData(r10, r11, r12);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "updateData failed: " + th.getMessage());
        return -1;
    }

    public static KmResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13) {
        return impl().xcrypt(r10, r11, r12, r13);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "xcrypt failed: " + th.getMessage());
        return new NoopKmResult(null);
    }
}
