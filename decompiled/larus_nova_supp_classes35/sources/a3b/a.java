package a3b;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Function1<Chatter, Unit> {
    public final m2b.a a;

    /* JADX INFO: renamed from: a3b.a$a, reason: collision with other inner class name */
    public static final class C0001a {
    }

    static {
    }

    public a(m2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
    }

    public final void a(Chatter r6) {
        Intrinsics.checkNotNullParameter(r6, "chatter");
        if (r6.isAnonymous() == false) goto L7;
        Log.i("ChatUserInfoClickHandler", "chatter is anonymous block avatar click");
        return;
    L7:
        if (r6.isProfileEnable() == true) goto L9;
        return;
    L9:
        if (this.a.e0() == false) goto L12;
        b0 r0 = ChatCoreModule.a().getProfileDependency();
        FragmentActivity r1 = this.a.getContext();
        ProfileSource.a r3 = new ProfileSource.a();
        r3.e = r6.getId();
        r3.g = r6.getType();
        r3.d = this.a.getChatId();
        r3.a = 2;
        r3.b = 0;
        r3.c = k.a(this.a.getChat());
        r0.e(r1, r3.a());
        return;
    L12:
        if (r6.isAnonymous() == false) goto L15;
        Log.i("ChatUserInfoClickHandler", "chatter is anonymous");
        return;
    L15:
        b0 r2 = ChatCoreModule.a().getProfileDependency();
        FragmentActivity r4 = this.a.getContext();
        ProfileSource.a r5 = new ProfileSource.a();
        r5.e = r6.getId();
        r5.g = r6.getType();
        r5.d = this.a.getChatId();
        r5.b = 0;
        r5.c = k.a(this.a.getChat());
        r2.e(r4, r5.a());
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((Chatter) r1);
        return Unit.INSTANCE;
    }
}
