package com.bytedance.android.live.liveinteract.linkbase.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MediaOperation {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/MediaOperation$Action;", "", "", "value", "I", "getValue", "()I", "CLOSE", "OPEN", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Action extends Enum<Action> {
        public static final Action CLOSE = null;
        public static final Action OPEN = null;
        public static final /* synthetic */ Action[] a = null;
        private final int value;

        static {
            Action r1 = new Action("CLOSE", 0, 0);
            CLOSE = r1;
            Action r2 = new Action("OPEN", 1, 1);
            OPEN = r2;
            a = new Action[]{r1, r2};
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Action(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/MediaOperation$Type;", "", "", "value", "I", "getValue", "()I", "CAMERA", "MIC", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> {
        public static final Type CAMERA = null;
        public static final Type MIC = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r1 = new Type("CAMERA", 0, 0);
            CAMERA = r1;
            Type r2 = new Type("MIC", 1, 1);
            MIC = r2;
            a = new Type[]{r1, r2};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public interface a {
        void onError(Throwable r1);

        void onSuccess();
    }

    public static final class b {
    }

    static {
    }

    public final Type getType() {
        return null;
    }
}
