package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u000e\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR<\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11;", "", "", "openExempt", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "", "", "Lcom/bytedance/android/livesdk/config/n11$b;", "config", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "c", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n11 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("config")
    private Map<String, ? extends Map<String, b>> config;

    @SerializedName("openExempt")
    private Boolean openExempt;

    public static final class a {
        @JvmStatic
        public static n11 a() {
            n11 r4 = new n11();
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
            Boolean r6 = Boolean.TRUE;     // Catch: Throwable -> L9
            r4.d(r6);     // Catch: Throwable -> L9
            LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L9
            LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L9
            b.a r9 = new b.a();     // Catch: Throwable -> L9
            r9.n(r6);     // Catch: Throwable -> L9
            r9.j(Boolean.FALSE);     // Catch: Throwable -> L9
            r9.l(r6);     // Catch: Throwable -> L9
            Iterator r10 = CollectionsKt.listOf(new String[]{"audioChatRoom", "audioKtv", "videoKtv"}).iterator();     // Catch: Throwable -> L9
        L5:
            if (r10.hasNext() == false) goto L7;
            String r11 = (String) r10.next();     // Catch: Throwable -> L9
            b r12 = new b();     // Catch: Throwable -> L9
            r12.c(r9);     // Catch: Throwable -> L9
            r12.d(r9);     // Catch: Throwable -> L9
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r8.put(r11, r12);     // Catch: Throwable -> L9
            goto L5
        L7:
            b r14 = new b();     // Catch: Throwable -> L9
            r14.d(r9);     // Catch: Throwable -> L9
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r8.put("videoChatRoom", r14);     // Catch: Throwable -> L9
            b r16 = new b();     // Catch: Throwable -> L9
            b.a r17 = new b.a();     // Catch: Throwable -> L9
            Boolean r18 = Boolean.TRUE;     // Catch: Throwable -> L9
            r17.n(r18);     // Catch: Throwable -> L9
            r17.j(r18);     // Catch: Throwable -> L9
            r17.m(r18);     // Catch: Throwable -> L9
            r17.i(r18);     // Catch: Throwable -> L9
            r16.d(r17);     // Catch: Throwable -> L9
            r16.c(r17);     // Catch: Throwable -> L9
            r8.put("game", r16);     // Catch: Throwable -> L9
            r7.put("enterBackground", r8);     // Catch: Throwable -> L9
            LinkedHashMap r19 = new LinkedHashMap();     // Catch: Throwable -> L9
            b r20 = new b();     // Catch: Throwable -> L9
            b.a r21 = new b.a();     // Catch: Throwable -> L9
            r21.n(r18);     // Catch: Throwable -> L9
            Boolean r110 = Boolean.FALSE;     // Catch: Throwable -> L9
            r21.j(r110);     // Catch: Throwable -> L9
            b.a.C0111a r111 = new b.a.C0111a();     // Catch: Throwable -> L9
            r111.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r21.k(r111);     // Catch: Throwable -> L9
            r20.d(r21);     // Catch: Throwable -> L9
            b.a r22 = new b.a();     // Catch: Throwable -> L9
            r22.n(r18);     // Catch: Throwable -> L9
            r22.j(r110);     // Catch: Throwable -> L9
            b.a.C0111a r112 = new b.a.C0111a();     // Catch: Throwable -> L9
            r112.f(CollectionsKt.listOf(new String[]{"CameraActivity", "AlbumActivity"}));     // Catch: Throwable -> L9
            r22.k(r112);     // Catch: Throwable -> L9
            r20.c(r22);     // Catch: Throwable -> L9
            r19.put("audioKtv", r20);     // Catch: Throwable -> L9
            b r2 = new b();     // Catch: Throwable -> L9
            b.a r23 = new b.a();     // Catch: Throwable -> L9
            r23.n(r18);     // Catch: Throwable -> L9
            r23.j(r110);     // Catch: Throwable -> L9
            b.a.C0111a r24 = new b.a.C0111a();     // Catch: Throwable -> L9
            r24.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r23.k(r24);     // Catch: Throwable -> L9
            r2.d(r23);     // Catch: Throwable -> L9
            r19.put("videoKtv", r2);     // Catch: Throwable -> L9
            b r1 = new b();     // Catch: Throwable -> L9
            b.a r3 = new b.a();     // Catch: Throwable -> L9
            r3.n(r18);     // Catch: Throwable -> L9
            r3.j(r18);     // Catch: Throwable -> L9
            r3.m(r18);     // Catch: Throwable -> L9
            r3.i(r18);     // Catch: Throwable -> L9
            r1.d(r3);     // Catch: Throwable -> L9
            r1.c(r3);     // Catch: Throwable -> L9
            r19.put("game", r1);     // Catch: Throwable -> L9
            b r25 = new b();     // Catch: Throwable -> L9
            b.a r26 = new b.a();     // Catch: Throwable -> L9
            r26.n(r18);     // Catch: Throwable -> L9
            r26.j(r110);     // Catch: Throwable -> L9
            r26.m(r18);     // Catch: Throwable -> L9
            r26.i(r110);     // Catch: Throwable -> L9
            b.a.C0111a r27 = new b.a.C0111a();     // Catch: Throwable -> L9
            r27.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r27.g(CollectionsKt.listOf("AnchorV3FullScreenFragment"));     // Catch: Throwable -> L9
            r26.k(r27);     // Catch: Throwable -> L9
            r25.d(r26);     // Catch: Throwable -> L9
            r25.c(r26);     // Catch: Throwable -> L9
            r19.put("global", r25);     // Catch: Throwable -> L9
            r7.put("coverByPage", r19);     // Catch: Throwable -> L9
            r4.c(r7);     // Catch: Throwable -> L9
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            return r4;
        L9:
            th = move-exception;
            Result.Companion r28 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b;", "", "Lcom/bytedance/android/livesdk/config/n11$b$a;", "anchorConfig", "Lcom/bytedance/android/livesdk/config/n11$b$a;", "a", "()Lcom/bytedance/android/livesdk/config/n11$b$a;", "c", "(Lcom/bytedance/android/livesdk/config/n11$b$a;)V", "audienceConfig", "b", "d", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("anchorConfig")
        private a anchorConfig;

        @SerializedName("audienceConfig")
        private a audienceConfig;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R4\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b$a;", "", "", "needExemptCameraCheck", "Ljava/lang/Boolean;", "g", "()Ljava/lang/Boolean;", "m", "(Ljava/lang/Boolean;)V", "needExemptMicCheck", "h", "n", "exemptAllCameraCheck", "a", "i", "exemptAllMicCheck", "b", "j", "needCheckCameraNotification", "getNeedCheckCameraNotification", "setNeedCheckCameraNotification", "needCheckMicNotification", "f", "l", "needCheckIsFloatMode", "e", "setNeedCheckIsFloatMode", "Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "exemptCameraCheckPageConfig", "Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "c", "()Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "setExemptCameraCheckPageConfig", "(Lcom/bytedance/android/livesdk/config/n11$b$a$a;)V", "exemptMicCheckPageConfig", "d", "k", "", "", "extraConfig", "Ljava/util/Map;", "getExtraConfig", "()Ljava/util/Map;", "setExtraConfig", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("exemptAllCameraCheck")
            private Boolean exemptAllCameraCheck;

            @SerializedName("exemptAllMicCheck")
            private Boolean exemptAllMicCheck;

            @SerializedName("exemptCameraCheckPageConfig")
            private C0111a exemptCameraCheckPageConfig;

            @SerializedName("exemptMicCheckPageConfig")
            private C0111a exemptMicCheckPageConfig;

            @SerializedName("extraConfig")
            private Map<String, ? extends Object> extraConfig;

            @SerializedName("needCheckCameraNotification")
            private Boolean needCheckCameraNotification;

            @SerializedName("needCheckIsFloatMode")
            private Boolean needCheckIsFloatMode;

            @SerializedName("needCheckMicNotification")
            private Boolean needCheckMicNotification;

            @SerializedName("needExemptCameraCheck")
            private Boolean needExemptCameraCheck;

            @SerializedName("needExemptMicCheck")
            private Boolean needExemptMicCheck;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.config.n11$b$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "", "", "", "activityList", "Ljava/util/List;", "a", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "fragmentList", "b", "g", "needCheckUrlPageList", "d", "setNeedCheckUrlPageList", "urlList", "e", "setUrlList", "ignoreStates", "c", "setIgnoreStates", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class C0111a {

                @SerializedName("activityList")
                private List<String> activityList;

                @SerializedName("fragmentList")
                private List<String> fragmentList;

                @SerializedName("ignoreStates")
                private List<String> ignoreStates;

                @SerializedName("needCheckUrlPageList")
                private List<String> needCheckUrlPageList;

                @SerializedName("urlList")
                private List<String> urlList;

                public C0111a() {
                }

                public final List<String> a() {
                    return this.activityList;
                }

                public final List<String> b() {
                    return this.fragmentList;
                }

                public final List<String> c() {
                    return this.ignoreStates;
                }

                public final List<String> d() {
                    return this.needCheckUrlPageList;
                }

                public final List<String> e() {
                    return this.urlList;
                }

                public final void f(List<String> r1) {
                    this.activityList = r1;
                }

                public final void g(List<String> r1) {
                    this.fragmentList = r1;
                }
            }

            public a() {
                Boolean r0 = Boolean.FALSE;
                this.needExemptCameraCheck = r0;
                this.needExemptMicCheck = r0;
                this.exemptAllCameraCheck = r0;
                this.exemptAllMicCheck = r0;
                this.needCheckCameraNotification = r0;
                this.needCheckMicNotification = r0;
                this.needCheckIsFloatMode = r0;
            }

            public final Boolean a() {
                return this.exemptAllCameraCheck;
            }

            public final Boolean b() {
                return this.exemptAllMicCheck;
            }

            public final C0111a c() {
                return this.exemptCameraCheckPageConfig;
            }

            public final C0111a d() {
                return this.exemptMicCheckPageConfig;
            }

            public final Boolean e() {
                return this.needCheckIsFloatMode;
            }

            public final Boolean f() {
                return this.needCheckMicNotification;
            }

            public final Boolean g() {
                return this.needExemptCameraCheck;
            }

            public final Boolean h() {
                return this.needExemptMicCheck;
            }

            public final void i(Boolean r1) {
                this.exemptAllCameraCheck = r1;
            }

            public final void j(Boolean r1) {
                this.exemptAllMicCheck = r1;
            }

            public final void k(C0111a r1) {
                this.exemptMicCheckPageConfig = r1;
            }

            public final void l(Boolean r1) {
                this.needCheckMicNotification = r1;
            }

            public final void m(Boolean r1) {
                this.needExemptCameraCheck = r1;
            }

            public final void n(Boolean r1) {
                this.needExemptMicCheck = r1;
            }
        }

        public b() {
        }

        public final a a() {
            return this.anchorConfig;
        }

        public final a b() {
            return this.audienceConfig;
        }

        public final void c(a r1) {
            this.anchorConfig = r1;
        }

        public final void d(a r1) {
            this.audienceConfig = r1;
        }
    }

    static {
    }

    public n11() {
        this.openExempt = Boolean.TRUE;
        this.config = MapsKt.emptyMap();
    }

    public final Map<String, Map<String, b>> a() {
        return this.config;
    }

    public final Boolean b() {
        return this.openExempt;
    }

    public final void c(Map<String, ? extends Map<String, b>> r1) {
        this.config = r1;
    }

    public final void d(Boolean r1) {
        this.openExempt = r1;
    }
}
