package com.bytedance.android.livesdk.interactivity.api.seek;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EpisodeInteractivityTracer {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/seek/EpisodeInteractivityTracer$SubTag;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Danmaku", "Comment", "Seek", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SubTag extends Enum<SubTag> {
        public static final SubTag Comment = null;
        public static final SubTag Danmaku = null;
        public static final SubTag Seek = null;
        public static final /* synthetic */ SubTag[] a = null;
        private final String tag;

        static {
            SubTag r1 = new SubTag("Danmaku", 0, "Danmaku");
            Danmaku = r1;
            SubTag r2 = new SubTag("Comment", 1, "Comment");
            Comment = r2;
            SubTag r3 = new SubTag("Seek", 2, "Seek");
            Seek = r3;
            a = new SubTag[]{r1, r2, r3};
        }

        public static SubTag valueOf(String r1) {
            return (SubTag) a.a(SubTag.class, r1);
        }

        public static SubTag[] values() {
            return (SubTag[]) a.clone();
        }

        public final String getTag() {
            return this.tag;
        }

        public SubTag(String r1, int r2, String r3) {
            super(r1, r2);
            this.tag = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        ALogger.i("EpisodeMessage_" + SubTag.Comment.getTag(), r2);
    }

    @JvmStatic
    public static final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        ALogger.i("EpisodeMessage_" + SubTag.Danmaku.getTag(), r2);
    }

    @JvmStatic
    public static final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        ALogger.i("EpisodeMessage_" + SubTag.Seek.getTag(), r2);
    }
}
