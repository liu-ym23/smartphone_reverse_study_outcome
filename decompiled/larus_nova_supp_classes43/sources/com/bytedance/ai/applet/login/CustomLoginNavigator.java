package com.bytedance.ai.applet.login;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CustomLoginNavigator {
    public static final CustomLoginNavigator a = null;
    public static final ConcurrentHashMap<String, a> b = null;
    public static final ConcurrentHashMap<String, r4.f.a> c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/applet/login/CustomLoginNavigator$LaunchReason;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_PHONE_MASK", "OTHER_LOGIN_METHOD", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchReason extends Enum<LaunchReason> {
        public static final LaunchReason NO_PHONE_MASK = null;
        public static final LaunchReason OTHER_LOGIN_METHOD = null;
        public static final /* synthetic */ LaunchReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<LaunchReason> getEntries() {
            return b;
        }

        static {
            LaunchReason r0 = new LaunchReason("NO_PHONE_MASK", 0, "no_phone_mask");
            NO_PHONE_MASK = r0;
            LaunchReason r1 = new LaunchReason("OTHER_LOGIN_METHOD", 1, "other_login_method");
            OTHER_LOGIN_METHOD = r1;
            LaunchReason[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static LaunchReason[] values() {
            return (LaunchReason[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LaunchReason valueOf(String r1) {
            return (LaunchReason) r27.a.a(LaunchReason.class, r1);
        }

        public LaunchReason(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/login/CustomLoginNavigator$LaunchSource;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "FULL_PAGE", "UNKNOWN", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchSource extends Enum<LaunchSource> {
        public static final LaunchSource CHAT = null;
        public static final a Companion = null;
        public static final LaunchSource FULL_PAGE = null;
        public static final LaunchSource UNKNOWN = null;
        public static final /* synthetic */ LaunchSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<LaunchSource> getEntries() {
            return b;
        }

        static {
            LaunchSource r0 = new LaunchSource("CHAT", 0, "chat");
            CHAT = r0;
            LaunchSource r1 = new LaunchSource("FULL_PAGE", 1, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB);
            FULL_PAGE = r1;
            LaunchSource r10 = new LaunchSource("UNKNOWN", 2, "unknown");
            UNKNOWN = r10;
            LaunchSource[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static LaunchSource[] values() {
            return (LaunchSource[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LaunchSource valueOf(String r1) {
            return (LaunchSource) r27.a.a(LaunchSource.class, r1);
        }

        public LaunchSource(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final LaunchSource d;
        public final LaunchReason e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return ((((((r0 + r10) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "LaunchContext(appletId=" + this.a + ", messageId=" + this.b + ", url=" + this.c + ", source=" + this.d + ", reason=" + this.e + ')';
        }

        public a(String r10, String r11, String r12, LaunchSource r13, LaunchReason r14) {
            Intrinsics.checkNotNullParameter(r10, "appletId");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r13, "source");
            Intrinsics.checkNotNullParameter(r14, "reason");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
        }
    }

    public CustomLoginNavigator() {
    }

    static {
        a = new CustomLoginNavigator();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static void c(String r10) {
        r4.f.a r0 = c.remove(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        r4.f r1 = r4.a.n;
        if (r1 != null) goto L9;
        com.bytedance.ai.utils.g.a.w("CustomLoginNavigator", "unregisterHostMainActivityLifecycleCallback: lifecycleDepend is null, appletId=" + r10);
        return;
    L9:
        r1.a(r0);
    }

    public final Object a(String r14, String r15, String r16, String r17, String r18, Continuation<? super Result<Unit>> r19) {
        if ((r19 instanceof CustomLoginNavigator$navigateToCustomLogin$1) == false) goto L7;
        CustomLoginNavigator$navigateToCustomLogin$1 r10 = (CustomLoginNavigator$navigateToCustomLogin$1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        CustomLoginNavigator$navigateToCustomLogin$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r12.label;
        if (r20 == 0) goto L14;
        if (r20 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
        return ((Result) r1).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        LaunchSource.Companion.getClass();
        if (Intrinsics.areEqual(r15, "chat") == false) goto L19;
        LaunchSource r0 = LaunchSource.CHAT;
    L17:
        LaunchSource r21 = r0;
        LaunchReason r110 = LaunchReason.NO_PHONE_MASK;
        r12.label = 1;
        Object r22 = b(r14, r16, r17, r18, "mcp-login-page", r21, r110, r12);
        if (r22 != r13) goto L26;
        return r13;
    L26:
        return r22;
    L19:
        if (Intrinsics.areEqual(r15, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB) == false) goto L21;
        r0 = LaunchSource.FULL_PAGE;
        goto L17
    L21:
        r0 = LaunchSource.UNKNOWN;
    L7:
        r10 = new CustomLoginNavigator$navigateToCustomLogin$1(this, r19);
        goto L8
    }

    public final Object b(String r16, String r17, String r18, String r19, String r20, LaunchSource r21, LaunchReason r22, Continuation<? super Result<Unit>> r23) {
        if ((r23 instanceof CustomLoginNavigator$openLoginPage$1) == false) goto L7;
        CustomLoginNavigator$openLoginPage$1 r1 = (CustomLoginNavigator$openLoginPage$1) r23;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L18:
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        CustomLoginNavigator$openLoginPage$2 r14 = new CustomLoginNavigator$openLoginPage$2(r16, r21, r22, r17, r18, r19, r20, null);
        r1.label = 1;
        r0 = BuildersKt.withContext(r13, r14, r1);
        if (r0 != r11) goto L18;
        return r11;
    L7:
        r1 = new CustomLoginNavigator$openLoginPage$1(this, r23);
        goto L8
    }
}
