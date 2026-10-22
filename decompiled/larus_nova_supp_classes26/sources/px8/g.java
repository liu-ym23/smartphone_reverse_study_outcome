package px8;

import com.larus.camera.impl.entity.EduResultMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EduResultMode.values().length];
            r0[EduResultMode.SINGLE_QUESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EduResultMode.MULTI_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EduResultMode.HOMEWORK_CORRECTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EduResultMode.PHOTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
