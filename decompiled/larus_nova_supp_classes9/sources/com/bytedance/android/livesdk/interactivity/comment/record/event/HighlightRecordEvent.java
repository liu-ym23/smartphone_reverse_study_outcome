package com.bytedance.android.livesdk.interactivity.comment.record.event;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class HighlightRecordEvent {
    public static final /* synthetic */ int b = 0;
    public Type a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/event/HighlightRecordEvent$Type;", BuildConfig.FLAVOR, "START", "STOP", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type START = null;
        public static final Type STOP = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("START", 0);
            START = r1;
            Type r2 = new Type("STOP", 1);
            STOP = r2;
            a = new Type[]{r1, r2};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public HighlightRecordEvent() {
    }

    public final Type getType() {
        return this.a;
    }
}
