package a9b;

import com.bytedance.lark.pb.basic.v1.UserInfo;
import com.bytedance.lark.pb.contact.v2.UserContactStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public UserInfo a;
    public UserContactStatus b;

    /* JADX INFO: renamed from: a9b.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    static {
    }

    public a() {
    }

    public final UserInfo a() {
        UserInfo r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("userInfo");
        return null;
    }
}
