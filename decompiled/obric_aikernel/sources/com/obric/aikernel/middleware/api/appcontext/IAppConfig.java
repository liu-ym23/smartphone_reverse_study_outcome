package com.obric.aikernel.middleware.api.appcontext;

import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4504a = null;

    public static final enum HOST_TYPE extends Enum<HOST_TYPE> {
        private static final /* synthetic */ HOST_TYPE[] $VALUES = null;
        public static final HOST_TYPE BOE_HOST = null;
        public static final HOST_TYPE PPE_HOST = null;
        public static final HOST_TYPE RELEASE_HOST = null;
        private final int value;

        private static final /* synthetic */ HOST_TYPE[] $values() {
            return new HOST_TYPE[]{RELEASE_HOST, PPE_HOST, BOE_HOST};
        }

        static {
            RELEASE_HOST = new HOST_TYPE("RELEASE_HOST", 0, 0);
            PPE_HOST = new HOST_TYPE("PPE_HOST", 1, 1);
            BOE_HOST = new HOST_TYPE("BOE_HOST", 2, 2);
            $VALUES = $values();
        }

        private HOST_TYPE(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static HOST_TYPE valueOf(String r10) {
            return (HOST_TYPE) Enum.valueOf(HOST_TYPE.class, r10);
        }

        public static HOST_TYPE[] values() {
            return (HOST_TYPE[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4505a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Set<String> f4506b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f4507c = null;

        static {
            f4505a = new a();
            f4506b = SetsKt.setOf(new String[]{"test", "update"});
            f4507c = "toB_SS";
        }

        private a() {
        }

        public final Set<String> a() {
            return f4506b;
        }

        public final String b() {
            return f4507c;
        }
    }

    static {
        f4504a = a.f4505a;
    }
}
