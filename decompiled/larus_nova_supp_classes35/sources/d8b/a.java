package d8b;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.ss.android.lark.compose.chatsetting.add_chatter.FlowAddMemberActivity;
import com.ss.android.lark.compose.chatsetting.remove_chatter.FlowRemoveGroupMemberActivity;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1 instanceof AppCompatActivity) == false) goto L7;
        ((AppCompatActivity) r1).finish();
        return;
    }

    public static void b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intent r4 = new Intent(r2, FlowAddMemberActivity.class).putExtra("chat_id", r3);
        PassportcConvention.e(r4, LarkContext.getApplication());
        r2.startActivity(r4);
    }

    public static void d(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intent r4 = new Intent(r2, FlowRemoveGroupMemberActivity.class).putExtra("chat_id", r3);
        PassportcConvention.e(r4, LarkContext.getApplication());
        r2.startActivity(r4);
    }

    public static void c(Context r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "chatterId");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "chatterId");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "chatterId");
        ContactSource.a r0 = new ContactSource.a();
        r0.b = 2;
        r0.e = r9;
        r0.c = BuildConfig.FLAVOR;
        ContactSource r6 = new ContactSource(r0);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r2 = IProfileLauncherV2.Companion.a();
        Intrinsics.checkNotNull(r6);
        IProfileLauncherV2.a.a(r2, r8, r10, r9, r6, 154);
    }
}
