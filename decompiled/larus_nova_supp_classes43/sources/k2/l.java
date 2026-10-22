package k2;

import com.bytedance.ai.model.objects.PageType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PageType.values().length];
        r0[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
