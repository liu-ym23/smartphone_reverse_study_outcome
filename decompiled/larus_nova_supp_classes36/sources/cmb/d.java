package cmb;

import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: cmb.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0015a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[QuickLaunchBarItemType.values().length];
                r0[QuickLaunchBarItemType.ADD_ASSOCIATION_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[QuickLaunchBarItemType.ASSOCIATED_DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[QuickLaunchBarItemType.ASSOCIATED_DOC_WITH_COLLABORATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }
    }

    static {
    }
}
