package com.bytedance.android.anniex.base.depend;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ApplicationDepend {
    public String a;
    public final Lazy b;
    public final Lazy c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/ApplicationDepend$DomainParty;", "", "Companion", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DomainParty {
        public static final a Companion = null;
        public static final int FIRST = 1;
        public static final int SECOND = 2;
        public static final int THIRD = 3;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public Boolean b() {
        return null;
    }

    public final int a() {
        return ((Number) this.b.getValue()).intValue();
    }

    public ApplicationDepend() {
        this.b = LazyKt.lazy(new ApplicationDepend$cachedThemeColor$2(this));
        this.c = LazyKt.lazy(new ApplicationDepend$cachedTextColor$2(this));
    }
}
