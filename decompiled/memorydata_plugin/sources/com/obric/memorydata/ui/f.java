package com.obric.memorydata.ui;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.store.IStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018Bw\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u0003\u00126\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\fJ\u001e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fR>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/ui/IdentityAuthSessionStore;", "", "readInt", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "key", "", "defaultValue", "writeInt", EventBody.KEY_VALUE, "", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "(Lcom/obric/memorydata/middleware/api/store/IStore;)V", "markAuthenticated", "bootCount", "invalidate", "canRestore", "isInteractive", "isDeviceLocked", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<String, Integer, Integer> f13008b;
    private final Function2<String, Integer, Boolean> c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ui/IdentityAuthSessionStore$Companion;", "", "<init>", "()V", "KEY_AUTH_SESSION_STATE", "", "KEY_AUTH_SESSION_BOOT_COUNT", "STATE_REAUTH_REQUIRED", "", "STATE_AUTHENTICATED", "INVALID_BOOT_COUNT", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13007a = new a(null);
    }

    public f(IStore r3) {
        final IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "store");
        this(new $$Lambda$f$yzeEf9AMhe158rR6ZQ2UnmAHDQA(r4), new $$Lambda$f$eGB1C5imnp14N7WTG8FQRWDfXQ0(r4));
    }

    public f(Function2<? super String, ? super Integer, Integer> r3, Function2<? super String, ? super Integer, Boolean> r4) {
        Function2<String, Integer, Integer> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function2<String, Integer, Boolean> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "readInt");
        Intrinsics.checkNotNullParameter(r6, "writeInt");
        this.f13008b = r5;
        this.c = r6;
    }

    private static final int a(IStore r2, String r3, int r4) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        return r5.getInt(r3, r4);
    }

    private static final boolean b(IStore r2, String r3, int r4) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        return r5.syncSave(r3, r4);
    }

    public static /* synthetic */ boolean lambda$eGB1C5imnp14N7WTG8FQRWDfXQ0(IStore r0, String r1, int r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ int lambda$yzeEf9AMhe158rR6ZQ2UnmAHDQA(IStore r0, String r1, int r2) {
        return a(r0, r1, r2);
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke("memory_identity_auth_session_state", 0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(int r4) {
        if (r4 >= 0) goto L7;
        a();
        return false;
    L7:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke("memory_identity_auth_session_boot_count", Integer.valueOf(r4)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L11;
        a();
        return false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke("memory_identity_auth_session_state", 1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(int r4, boolean r5, boolean r6) {
        if (r4 < 0) goto L13;
        if (r5 == false) goto L14;
        if (r6 == false) goto L8;
        return false;
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(this.f13008b.invoke("memory_identity_auth_session_state", 0), Number.class, "com.obric.memorydata.plugin")).intValue() == 1) goto L10;
        return false;
    L10:
        if (((Number) ZeusTransformUtils.preCheckCast(this.f13008b.invoke("memory_identity_auth_session_boot_count", -1), Number.class, "com.obric.memorydata.plugin")).intValue() == r4) goto L12;
        return false;
    L12:
        return true;
    L14:
        return false;
    L13:
        return false;
    }
}
