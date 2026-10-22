package com.byted.mgl.merge.service.util.privacy;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010(\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010)\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010*\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010+\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010,\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010-\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010.\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007¨\u00060"}, d2 = {"Lcom/byted/mgl/merge/service/util/privacy/PrivacyTokenUtil;", "", "()V", "MGL_PRIVACY_TOKEN_MAP", "", "mTokenAudio", "getMTokenAudio", "()Ljava/lang/String;", "mTokenAudio$delegate", "Lkotlin/Lazy;", "mTokenCamera", "getMTokenCamera", "mTokenCamera$delegate", "mTokenClipboard", "getMTokenClipboard", "mTokenClipboard$delegate", "mTokenDevice", "getMTokenDevice", "mTokenDevice$delegate", "mTokenInstaller", "getMTokenInstaller", "mTokenInstaller$delegate", "mTokenLocation", "getMTokenLocation", "mTokenLocation$delegate", "mTokenMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTokenMedia", "getMTokenMedia", "mTokenMedia$delegate", "mTokenPermit", "getMTokenPermit", "mTokenPermit$delegate", "mTokenStorage", "getMTokenStorage", "mTokenStorage$delegate", "getAudioToken", "key", "getCameraToken", "getClipboardToken", "getDevInfoToken", "getInstallerToken", "getLocToken", "getMediaToken", "getPermitToken", "getStorageToken", "getTokenFromMap", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public final class PrivacyTokenUtil {
    public static final PrivacyTokenUtil INSTANCE = null;
    public static final String MGL_PRIVACY_TOKEN_MAP = "mgl_privacy_token_map";
    private static final Lazy mTokenAudio$delegate = null;
    private static final Lazy mTokenCamera$delegate = null;
    private static final Lazy mTokenClipboard$delegate = null;
    private static final Lazy mTokenDevice$delegate = null;
    private static final Lazy mTokenInstaller$delegate = null;
    private static final Lazy mTokenLocation$delegate = null;
    private static final HashMap<String, String> mTokenMap = null;
    private static final Lazy mTokenMedia$delegate = null;
    private static final Lazy mTokenPermit$delegate = null;
    private static final Lazy mTokenStorage$delegate = null;

    private PrivacyTokenUtil() {
    }

    private final String getMTokenAudio() {
        return (String) mTokenAudio$delegate.getValue();
    }

    private final String getMTokenCamera() {
        return (String) mTokenCamera$delegate.getValue();
    }

    private final String getMTokenClipboard() {
        return (String) mTokenClipboard$delegate.getValue();
    }

    private final String getMTokenDevice() {
        return (String) mTokenDevice$delegate.getValue();
    }

    private final String getMTokenInstaller() {
        return (String) mTokenInstaller$delegate.getValue();
    }

    private final String getMTokenLocation() {
        return (String) mTokenLocation$delegate.getValue();
    }

    private final String getMTokenMedia() {
        return (String) mTokenMedia$delegate.getValue();
    }

    private final String getMTokenPermit() {
        return (String) mTokenPermit$delegate.getValue();
    }

    private final String getMTokenStorage() {
        return (String) mTokenStorage$delegate.getValue();
    }

    static {
        INSTANCE = new PrivacyTokenUtil();
        mTokenMap = new HashMap();
        mTokenMedia$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenMedia$2.INSTANCE);
        mTokenAudio$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenAudio$2.INSTANCE);
        mTokenCamera$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenCamera$2.INSTANCE);
        mTokenClipboard$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenClipboard$2.INSTANCE);
        mTokenDevice$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenDevice$2.INSTANCE);
        mTokenLocation$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenLocation$2.INSTANCE);
        mTokenPermit$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenPermit$2.INSTANCE);
        mTokenInstaller$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenInstaller$2.INSTANCE);
        mTokenStorage$delegate = LazyKt.lazy(PrivacyTokenUtil$mTokenStorage$2.INSTANCE);
    }

    private final String getTokenFromMap(String r10) {
        HashMap<String, String> r0 = mTokenMap;
        if ((!r0.isEmpty()) == true) goto L5;
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L8:
        if ((!r0.isEmpty()) == false) goto L12;
        String r11 = r0.get(r10);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r11;
    L12:
        JSONObject r1 = BdpManager.getInst().getService(AMglInvCallerService.class).getSettings(MGL_PRIVACY_TOKEN_MAP);     // Catch: Throwable -> L24
        if (r1 == null) goto L20;
        Iterator<String> r12 = r1.keys();     // Catch: Throwable -> L24
    L16:
        if (r12.hasNext() == false) goto L20;
        String r13 = r12.next();     // Catch: Throwable -> L24
        String r14 = r1.optString(r13);     // Catch: Throwable -> L24
        if ((!StringsKt.isBlank(r14)) == false) goto L16;
        mTokenMap.put(r13, r14);     // Catch: Throwable -> L24
    L20:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        return mTokenMap.get(r10);
    L5:
        return r0.get(r10);
    }

    public final String getAudioToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenAudio();
    L4:
        return getMTokenAudio();
    }

    public final String getCameraToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenCamera();
    L4:
        return getMTokenCamera();
    }

    public final String getClipboardToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenClipboard();
    L4:
        return getMTokenClipboard();
    }

    public final String getDevInfoToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenDevice();
    L4:
        return getMTokenDevice();
    }

    public final String getInstallerToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenInstaller();
    L4:
        return getMTokenInstaller();
    }

    public final String getLocToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenLocation();
    L4:
        return getMTokenLocation();
    }

    public final String getMediaToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenMedia();
    L4:
        return getMTokenMedia();
    }

    public final String getPermitToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenPermit();
    L4:
        return getMTokenPermit();
    }

    public final String getStorageToken(String r1) {
        if (r1 == null) goto L4;
        String r10 = getTokenFromMap(r1);
        if (r10 == null) goto L8;
        return r10;
    L8:
        return getMTokenStorage();
    L4:
        return getMTokenStorage();
    }
}
