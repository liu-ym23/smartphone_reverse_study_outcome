package com.bytedance.crypto.utils;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.aiassistant.security.rot_provision.RotProvisionManager;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.security.keymanager.KeyManagerResult;
import com.obric.security.secretdata.QueryResult;
import el9.a;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

        public /* synthetic */ AiassistantImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r3, Object r4, Bundle r5) {
            if ((r4 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            AddResult r6 = SecretDataManager.getInstance().addData(r3, (com.aiassistant.security.secretdata.SecretData) r4, r5);
            if (r6 != null) goto L9;
            return -1;
        L9:
            return r6.getResultCode();
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
        public int deleteData(Context r2, String r3, Bundle r4) {
            return SecretDataManager.getInstance().deleteData(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            return KeyManager.getInstance().deleteKey(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r2, String r3) {
            return KeyManager.getInstance().deleteSyncKey(r2, r3);
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
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            return KeyManager.getInstance().generateKeyPair(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r2, String r3, Bundle r4) {
            return new AiassistantKmResult(KeyManager.getInstance().getCertificateChain(r2, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r2, Bundle r3) {
            return KeyManager.getInstance().importKey(r2, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r2, Bundle r3) {
            return KeyManager.getInstance().importKeyLegacy(r2, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r2, String r3, byte[] r4, Bundle r5) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAgreement(r2, r3, r4, r5), null);
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
        public KmResult keyAttestation(Context r2, String r3, Bundle r4) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAttestation(r2, r3, r4), null);
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
        public byte[] platformKeyDecrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            return PlatformKeyManager.getInstance().decrypt(r7, r8, r9, r10, r11);
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
        public SdQueryResult queryData(Context r2, String r3, Bundle r4) {
            return new AiassistantSdQueryResult(SecretDataManager.getInstance().queryData(r2, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r2, Bundle r3) {
            String r4 = RotProvisionManager.getInstance().checkState(r2, r3);
            if (r4 != null) goto L6;
            return "";
        L6:
            return r4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r1) {
            String r2 = ((com.aiassistant.security.secretdata.SecretData) r1).extInfo;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r1) {
            String r2 = ((com.aiassistant.security.secretdata.SecretData) r1).publicData;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r1) {
            String r2 = ((com.aiassistant.security.secretdata.SecretData) r1).searchInfo;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r1) {
            String r2 = ((com.aiassistant.security.secretdata.SecretData) r1).secretData;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r1, String r2) {
            ((com.aiassistant.security.secretdata.SecretData) r1).alias = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r1, String r2) {
            ((com.aiassistant.security.secretdata.SecretData) r1).extInfo = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r1, String r2) {
            ((com.aiassistant.security.secretdata.SecretData) r1).publicData = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r1, String r2) {
            ((com.aiassistant.security.secretdata.SecretData) r1).searchInfo = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r1, String r2) {
            ((com.aiassistant.security.secretdata.SecretData) r1).secretData = r2;
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
        public int updateData(Context r2, Object r3, Bundle r4) {
            if ((r3 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return SecretDataManager.getInstance().updateData(r2, (com.aiassistant.security.secretdata.SecretData) r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r2, int r3, byte[] r4, Bundle r5) {
            return new AiassistantKmResult(KeyManager.getInstance().xcrypt(r2, r3, r4, r5), null);
        }
    }

    public interface Impl {
        int addData(Context r1, Object r2, Bundle r3);

        String additionalData();

        String bundleKeyQueryMode();

        String challenge();

        int deleteData(Context r1, String r2, Bundle r3);

        int deleteKey(Context r1, String r2, Bundle r3);

        int deleteSyncKey(Context r1, String r2);

        String deviceHealthStatusRequired();

        String eccPrivateKey();

        String eccPublicKey();

        int generateKeyPair(Context r1, String r2, Bundle r3);

        KmResult getCertificateChain(Context r1, String r2, Bundle r3);

        int importKey(Context r1, Bundle r2);

        int importKeyLegacy(Context r1, Bundle r2);

        KmResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4);

        String keyAlgo();

        int keyAlgorithmEcc();

        String keyAlias();

        KmResult keyAttestation(Context r1, String r2, Bundle r3);

        String keyLen();

        String keyPurpose();

        int kmSuccess();

        Object newSecretData();

        int platformIvLen();

        byte[] platformKeyDecrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5);

        int platformMagicNumLen();

        int platformSm8750();

        int platformVerLen();

        int preciseQueryAndDecrypt();

        int purposeAgreeKey();

        int purposeAttestKey();

        SdQueryResult queryData(Context r1, String r2, Bundle r3);

        String rotCheckState(Context r1, Bundle r2);

        String sdGetExtInfo(Object r1);

        String sdGetPublicData(Object r1);

        String sdGetSearchInfo(Object r1);

        String sdGetSecretData(Object r1);

        void sdSetAlias(Object r1, String r2);

        void sdSetExtInfo(Object r1, String r2);

        void sdSetPublicData(Object r1, String r2);

        void sdSetSearchInfo(Object r1, String r2);

        void sdSetSecretData(Object r1, String r2);

        int secretDataNotFound();

        int secretSuccess();

        int updateData(Context r1, Object r2, Bundle r3);

        String wrappedKeyData();

        KmResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4);
    }

    public interface KmResult {
        List<Certificate> getCertChain();

        byte[] getOutData();

        int getResultCode();
    }

    public static final class NoopImpl implements Impl {
        private NoopImpl() {
        }

        public /* synthetic */ NoopImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r1, Object r2, Bundle r3) {
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
        public int deleteData(Context r1, String r2, Bundle r3) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r1, String r2, Bundle r3) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r1, String r2) {
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
        public int generateKeyPair(Context r1, String r2, Bundle r3) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r1, String r2, Bundle r3) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r1, Bundle r2) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r1, Bundle r2) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4) {
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
        public KmResult keyAttestation(Context r1, String r2, Bundle r3) {
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
        public byte[] platformKeyDecrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5) {
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
        public SdQueryResult queryData(Context r1, String r2, Bundle r3) {
            return new NoopSdQueryResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r1, Bundle r2) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r1) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r1, String r2) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r1, String r2) {
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
        public int updateData(Context r1, Object r2, Bundle r3) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "WRAPPED_KEY_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4) {
            return new NoopKmResult(null);
        }
    }

    public static final class NoopKmResult implements KmResult {
        private NoopKmResult() {
        }

        public /* synthetic */ NoopKmResult(AnonymousClass1 r1) {
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

        public /* synthetic */ NoopSdQueryResult(AnonymousClass1 r1) {
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

        public /* synthetic */ ObricImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r3, Object r4, Bundle r5) {
            if ((r4 instanceof com.obric.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            com.obric.security.secretdata.AddResult r6 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r3, (com.obric.security.secretdata.SecretData) r4, r5);
            if (r6 != null) goto L9;
            return -1;
        L9:
            return r6.getResultCode();
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
        public int deleteData(Context r2, String r3, Bundle r4) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r2, String r3, Bundle r4) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r2, String r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteSyncKey(r2, r3);
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
        public int generateKeyPair(Context r2, String r3, Bundle r4) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r2, r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r2, String r3, Bundle r4) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().getCertificateChain(r2, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKey(r2, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKeyLegacy(r2, r3);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r2, String r3, byte[] r4, Bundle r5) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAgreement(r2, r3, r4, r5), null);
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
        public KmResult keyAttestation(Context r2, String r3, Bundle r4) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r2, r3, r4), null);
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
        public byte[] platformKeyDecrypt(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().decrypt(r7, r8, r9, r10, r11);
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
        public SdQueryResult queryData(Context r2, String r3, Bundle r4) {
            return new ObricSdQueryResult(com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r2, r3, r4), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r2, Bundle r3) {
            String r4 = com.obric.security.rot_provision.RotProvisionManager.getInstance().checkState(r2, r3);
            if (r4 != null) goto L6;
            return "";
        L6:
            return r4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r1) {
            String r2 = ((com.obric.security.secretdata.SecretData) r1).extInfo;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r1) {
            String r2 = ((com.obric.security.secretdata.SecretData) r1).publicData;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r1) {
            String r2 = ((com.obric.security.secretdata.SecretData) r1).searchInfo;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r1) {
            String r2 = ((com.obric.security.secretdata.SecretData) r1).secretData;
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r1, String r2) {
            ((com.obric.security.secretdata.SecretData) r1).alias = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r1, String r2) {
            ((com.obric.security.secretdata.SecretData) r1).extInfo = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r1, String r2) {
            ((com.obric.security.secretdata.SecretData) r1).publicData = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r1, String r2) {
            ((com.obric.security.secretdata.SecretData) r1).searchInfo = r2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r1, String r2) {
            ((com.obric.security.secretdata.SecretData) r1).secretData = r2;
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
        public int updateData(Context r2, Object r3, Bundle r4) {
            if ((r3 instanceof com.obric.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return com.obric.security.secretdata.SecretDataManager.getInstance().updateData(r2, (com.obric.security.secretdata.SecretData) r3, r4);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r2, int r3, byte[] r4, Bundle r5) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().xcrypt(r2, r3, r4, r5), null);
        }
    }

    public static final class ObricKmResult implements KmResult {
        private final KeyManagerResult m;

        private ObricKmResult(KeyManagerResult r1) {
            this.m = r1;
        }

        public /* synthetic */ ObricKmResult(KeyManagerResult r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return new byte[0];
        L6:
            return r0.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            KeyManagerResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
        }
    }

    public static final class ObricSdQueryResult implements SdQueryResult {
        private final QueryResult m;

        private ObricSdQueryResult(QueryResult r1) {
            this.m = r1;
        }

        public /* synthetic */ ObricSdQueryResult(QueryResult r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r0.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            QueryResult r0 = this.m;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getResultCode();
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

        public static String getExtInfo(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetExtInfo(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getExtInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getPublicData(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetPublicData(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getPublicData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSearchInfo(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSearchInfo(r3);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSearchInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSecretData(Object r3) {
            if (r3 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSecretData(r3);
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

        public static void setAlias(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetAlias(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setAlias failed: " + th.getMessage());
            return;
        }

        public static void setExtInfo(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetExtInfo(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setExtInfo failed: " + th.getMessage());
            return;
        }

        public static void setPublicData(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetPublicData(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setPublicData failed: " + th.getMessage());
            return;
        }

        public static void setSearchInfo(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSearchInfo(r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSearchInfo failed: " + th.getMessage());
            return;
        }

        public static void setSecretData(Object r1, String r2) {
            if (r1 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSecretData(r1, r2);     // Catch: Throwable -> L5
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

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static /* synthetic */ Impl access$900() {
        return impl();
    }

    public static int addData(Context r1, Object r2, Bundle r3) {
        return impl().addData(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "addData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteData(Context r1, String r2, Bundle r3) {
        return impl().deleteData(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteKey(Context r1, String r2, Bundle r3) {
        return impl().deleteKey(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteKey failed: " + th.getMessage());
        return -1;
    }

    public static int deleteSyncKey(Context r1, String r2) {
        return impl().deleteSyncKey(r1, r2);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteSyncKey failed: " + th.getMessage());
        return -1;
    }

    public static int generateKeyPair(Context r1, String r2, Bundle r3) {
        return impl().generateKeyPair(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "generateKeyPair failed: " + th.getMessage());
        return -1;
    }

    public static KmResult getCertificateChain(Context r1, String r2, Bundle r3) {
        return impl().getCertificateChain(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "getCertificateChain failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    private static boolean hasClass(String r3) {
        INVOKESTATIC_com_bytedance_crypto_utils_FrameworkSecurityCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
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
        Impl r1 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r1;
    L13:
        AnonymousClass1 r2 = null;
        if (hasClass(OBric_SECRET_DATA_MANAGER) == false) goto L17;
        sImpl = new ObricImpl(r2);     // Catch: Throwable -> L24
        String r3 = TAG;
        String r4 = "Resolved framework security package: com.obric.security";
    L19:
        LogUtils.i(r3, r4);     // Catch: Throwable -> L24
    L21:
        Impl r5 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r5;
    L17:
        if (hasClass(AIASSISTANT_SECRET_DATA_MANAGER) == false) goto L20;
        sImpl = new AiassistantImpl(r2);     // Catch: Throwable -> L24
        r3 = TAG;
        r4 = "Resolved framework security package: com.aiassistant.security";
        goto L19
    L20:
        sImpl = new NoopImpl(r2);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No framework security package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static int importKey(Context r1, Bundle r2) {
        return impl().importKey(r1, r2);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKey failed: " + th.getMessage());
        return -1;
    }

    public static int importKeyLegacy(Context r1, Bundle r2) {
        return impl().importKeyLegacy(r1, r2);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKeyLegacy failed: " + th.getMessage());
        return -1;
    }

    public static KmResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4) {
        return impl().keyAgreement(r1, r2, r3, r4);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAgreement failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static KmResult keyAttestation(Context r1, String r2, Bundle r3) {
        return impl().keyAttestation(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAttestation failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static byte[] platformKeyDecrypt(Context r6, int r7, byte[] r8, byte[] r9, Bundle r10) {
        return impl().platformKeyDecrypt(r6, r7, r8, r9, r10);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "platformKeyDecrypt failed: " + th.getMessage());
        return null;
    }

    public static SdQueryResult queryData(Context r1, String r2, Bundle r3) {
        return impl().queryData(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "queryData failed: " + th.getMessage());
        return new NoopSdQueryResult(null);
    }

    public static String rotCheckState(Context r1, Bundle r2) {
        return impl().rotCheckState(r1, r2);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "rotCheckState failed: " + th.getMessage());
        return "";
    }

    public static int updateData(Context r1, Object r2, Bundle r3) {
        return impl().updateData(r1, r2, r3);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "updateData failed: " + th.getMessage());
        return -1;
    }

    public static KmResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4) {
        return impl().xcrypt(r1, r2, r3, r4);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "xcrypt failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_crypto_utils_FrameworkSecurityCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }
}
