package com.ss.android.lark.chat.base.model.dispatch;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class PreprocessParams {
    public final ResourceType a;
    public final f b;
    public final Lazy c;

    public static final class a {
        public ResourceType a;
        public String b;
        public boolean c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.base.model.dispatch.PreprocessParams$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0028a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ResourceType.values().length];
                r0[ResourceType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public a() {
            f r0 = f.f;
        }
    }

    public static final class b {
    }

    static {
    }

    public abstract boolean a();

    public abstract String b();

    public final ResourceType getType() {
        return this.a;
    }

    public PreprocessParams(ResourceType r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "preUploadParams");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new PreprocessParams$hashedPath$2(this));
    }
}
