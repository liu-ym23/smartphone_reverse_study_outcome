package m38;

import com.larus.account.base.model.LoginPlatform;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LoginPlatform.values().length];
        r0[LoginPlatform.PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[LoginPlatform.GOOGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[LoginPlatform.DOUYIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
