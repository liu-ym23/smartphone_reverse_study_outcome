package peb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {

    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: peb.b$b, reason: collision with other inner class name */
    public interface InterfaceC0277b {
        void a();

        lpb.a b(com.ss.android.lark.feed.shared.data.appconfig.d r1);

        void c();
    }

    public interface c {
        void a();

        void b(Context r1, String r2);
    }

    public interface d {
        void a(Context r1, String r2, int r3, boolean r4);

        void b(Context r1, String r2, int r3, boolean r4);

        void c(Context r1, Fragment r2, String r3, int r4, boolean r5);

        void d(Context r1, String r2, Chat.ChatMode r3, boolean r4, String r5, int r6, boolean r7);
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
        boolean isCurrentEnable(String r1);

        boolean isEnable(String r1);
    }

    public interface g {
        void b();

        void c();
    }

    public interface h {
    }

    public interface i {
        void a();

        void b(afb.b.a r1);
    }

    public interface j {
        String a(List<Chatter.ChatterCustomStatus> r1);

        RichText b(String r1);
    }

    public interface k {
        void a();

        boolean b();

        void c(h r1);

        void d();

        Locale getCacheLanguageSetting();

        boolean isInZenMode(long r1);
    }

    a getAccountDependency();

    InterfaceC0277b getAppConfigDependency();

    Context getApplictaionContext();

    c getBrowserDependency();

    d getChatDependency();

    e getDocDependency();

    f getFeatureGatingDependency();

    peb.a getFeedDependency();

    g getGuideDependency();

    i getPushDependency();

    j getResourceDependency();

    k getSettingDependency();
}
