package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.exception.ApiException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class y {
    public final String a;

    public static final class a {
    }

    public static final class b extends y {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "Hold";
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public final String a() {
            return b;
        }
    }

    public static abstract class c extends y {
        public final String b;

        public static abstract class a extends c {
            public final int c;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.model.y$c$a$a, reason: collision with other inner class name */
            public static class C0067a extends a {
                public final ApiException d;
                public final boolean e;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "ApiFailed , code is " + this.d.getErrorCode() + ", message is : " + this.d.getMessage() + ", isHandler is : " + this.e;
                }

                public C0067a(ApiException r2, boolean r3, int r4) {
                    Intrinsics.checkNotNullParameter(r2, "originException");
                    super(r4);
                    this.d = r2;
                    this.e = r3;
                }
            }

            public static final class b extends C0067a {
                public b(ApiException r3) {
                    Intrinsics.checkNotNullParameter(r3, "originException");
                    super(r3, false, 103);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.model.y$c$a$c, reason: collision with other inner class name */
            public static final class C0068c extends a {
                public static final C0068c d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "BuffCardAccountFailed";
                }

                static {
                    d = new C0068c();
                }

                public C0068c() {
                    super(101);
                }
            }

            public static final class d extends C0067a {
                public d(ApiException r3) {
                    Intrinsics.checkNotNullParameter(r3, "originException");
                    super(r3, true, 104);
                }
            }

            public static final class e extends a {
                public final String d;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "InvalidEnv, errMessage is " + this.d;
                }

                public e(int r2, String r3) {
                    Intrinsics.checkNotNullParameter(r3, "errMsg");
                    super(r2);
                    this.d = r3;
                }
            }

            public static final class f extends a {
                public final String d;

                public f() {
                    Intrinsics.checkNotNullParameter("count != groupCount", "errMsg");
                    super(202);
                    this.d = "count != groupCount";
                }

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "InvalidParam, errMessage is " + this.d;
                }
            }

            public static final class g extends C0067a {
                public final int f;

                public g(ApiException r3, int r4) {
                    Intrinsics.checkNotNullParameter(r3, "originException");
                    super(r3, false, 102);
                    this.f = r4;
                }
            }

            public static final class h extends a {
                public static final h d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "NetTimeOut";
                }

                static {
                    d = new h();
                }

                public h() {
                    super(105);
                }
            }

            public static final class i extends a {
                public static final i d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "TimeOut";
                }

                static {
                    d = new i();
                }

                public i() {
                    super(100);
                }
            }

            public a(int r1) {
                this.c = r1;
            }
        }

        public static final class b extends c {
            public static final String c = null;
            public static final b d = null;

            static {
                d = new b();
                c = "SkipToIdle";
            }

            public b() {
            }

            @Override // com.bytedance.android.livesdk.gift.platform.core.model.y.c, com.bytedance.android.livesdk.gift.platform.core.model.y
            public final String a() {
                return c;
            }
        }

        public c() {
            this.b = "Intercept";
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public String a() {
            return this.b;
        }
    }

    public static final class d extends y {
        public static final String b = null;
        public static final d c = null;

        static {
            c = new d();
            b = "Pass";
        }

        public d() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public final String a() {
            return b;
        }
    }

    static {
    }

    public String toString() {
        return "PluginResponse " + a();
    }

    public y() {
        this.a = "default";
    }

    public String a() {
        return this.a;
    }
}
