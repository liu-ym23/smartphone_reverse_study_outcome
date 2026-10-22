package ty7;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.card.component.avatar.UniversalCardLynxAvatarUI;
import com.larksuite.component.card.component.checkbox.UniversalCardLynxCheckBoxUI;
import com.larksuite.component.card.component.header.UniversalCardHeaderBgUI;
import com.larksuite.component.card.component.image.UniversalCardLynxImageUI;
import com.larksuite.component.card.component.lottie.LottieUI;
import com.larksuite.component.card.component.personlist.PersonListLynxUI;
import com.larksuite.component.card.component.personlist.avatar.PersonAvatarGroupLynxUI;
import com.larksuite.component.card.component.personlist.avatar.d;
import com.larksuite.component.card.component.personlist.c;
import com.larksuite.component.card.component.slider.UniversalCardLynxSliderUI;
import com.larksuite.component.card.component.table.TableMarkdownUI;
import com.larksuite.component.card.component.text.UniversalCardTextLynxUI;
import com.larksuite.component.card.component.text.g;
import com.larksuite.component.card.component.udicon.UniversalCardUDIconUI;
import com.larksuite.component.card.debugger.ICardDebugger;
import com.larksuite.component.card.plugin.CardDigestPlugin;
import com.larksuite.component.card.plugin.CardGetHostInfoPlugin;
import com.larksuite.component.card.plugin.CardOpenUrlPlugin;
import com.larksuite.component.card.plugin.CardUpdateLocalDataPlugin;
import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.larksuite.component.card.plugin.GetAppSettingsPlugin;
import com.larksuite.component.card.plugin.MsgCardShowOverflowPlugin;
import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.card.plugin.OnSubmitInputPlugin;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larksuite.component.card.plugin.SendClientMessagePlugin;
import com.larksuite.component.card.plugin.SendRequestPlugin;
import com.larksuite.component.card.plugin.ShowCardChartPlugin;
import com.larksuite.component.card.plugin.ShowCardToastPlugin;
import com.larksuite.component.card.plugin.ShowConfirmPlugin;
import com.larksuite.component.card.plugin.ShowDatePickerPlugin;
import com.larksuite.component.card.plugin.ShowProfilePlugin;
import com.larksuite.component.card.plugin.ShowSelectMenuPlugin;
import com.larksuite.component.card.plugin.ShowTableDetailPlugin;
import com.larksuite.component.card.plugin.UpdateStreamingStatePlugin;
import com.larksuite.component.card.plugin.audio.CardGetAudioStatePlugin;
import com.larksuite.component.card.plugin.audio.CardOperateAudioPlugin;
import com.larksuite.component.card.plugin.video.CardPreviewVideoPlugin;
import com.larksuite.component.card.utils.k;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.utils.LarkContext;
import idb.f;
import java.util.ArrayList;
import java.util.Iterator;
import l18.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static volatile yy7.a a;

    /* JADX INFO: renamed from: ty7.a$a, reason: collision with other inner class name */
    public class C0128a implements com.ss.android.lark.lynxkit.initializer.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        public final LynxGroup a() {
            if (this.a == false) goto L5;
            LynxEnv.inst().tryToLoadV8Bridge(false);
        L5:
            String r3 = LynxGroup.SINGNLE_GROUP;
            return LynxGroup.Create(r3, r3, null, false, this.b, this.a);
        }

        public C0128a(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public static yy7.a a() {
        a r0 = b.a;
        if (a != null) goto L14;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (a != null) goto L8;
        a = (yy7.a) ClaymoreServiceLoader.loadFirst(yy7.a.class);     // Catch: Throwable -> L10
        LarkLynxKitInitializer.Companion.getClass();     // Catch: Throwable -> L10
        LarkLynxKitInitializer r1 = LarkLynxKitInitializer.b.a();     // Catch: Throwable -> L10
        LarkContext.getApplication();     // Catch: Throwable -> L10
        r1.registerCustomComponents("UniversalCard", b());     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
    L14:
        return a;
    }

    public static ArrayList b() {
        ArrayList r0 = new ArrayList();
        int r1 = UniversalCardLynxImageUI.f;
        r0.add(new com.larksuite.component.card.component.image.b());
        int r2 = UniversalCardTextLynxUI.g;
        r0.add(new g());
        int r3 = UniversalCardHeaderBgUI.a;
        r0.add(new com.larksuite.component.card.component.header.a());
        int r4 = UniversalCardUDIconUI.d;
        r0.add(new com.larksuite.component.card.component.udicon.a());
        int r5 = PersonListLynxUI.a;
        r0.add(new c());
        int r6 = PersonAvatarGroupLynxUI.a;
        r0.add(new d());
        int r7 = UniversalCardLynxAvatarUI.b;
        r0.add(new com.larksuite.component.card.component.avatar.a());
        int r8 = UniversalCardLynxCheckBoxUI.c;
        r0.add(new com.larksuite.component.card.component.checkbox.b());
        int r9 = TableMarkdownUI.d;
        r0.add(new com.larksuite.component.card.component.table.a());
        int r10 = LottieUI.a;
        r0.add(new com.larksuite.component.card.component.lottie.a());
        int r11 = xy7.b.a;
        r0.add(new xy7.a());
        int r12 = xy7.d.a;
        r0.add(new xy7.c());
        int r13 = UniversalCardLynxSliderUI.a;
        r0.add(new com.larksuite.component.card.component.slider.b());
        int r14 = com.larksuite.component.card.debugger.b.a;
        ICardDebugger.a.getClass();
        r0.addAll(((ICardDebugger) ICardDebugger.Companion.b.getValue()).b());
        return r0;
    }

    public static void c() {
        Context r0 = a.getContext();
        if (r0 != null) goto L5;
        r0 = com.larksuite.framework.utils.b.a.getApplicationContext();
    L5:
        jz7.b r1 = new jz7.b(r0);
        h r2 = r1.a;
        r2.b(new ShowCardToastPlugin());
        r2.b(new CardDigestPlugin());
        r2.b(new CardUpdateLocalDataPlugin());
        r2.b(new CardOpenUrlPlugin());
        r2.b(new MsgCardShowOverflowPlugin());
        r2.b(new OnSubmitInputPlugin());
        r2.b(new ShowDatePickerPlugin());
        r2.b(new ShowSelectMenuPlugin());
        r2.b(new ShowConfirmPlugin());
        r2.b(new SendRequestPlugin());
        r2.b(new SendClientMessagePlugin());
        r2.b(new ReportCardMonitorPlugin());
        r2.b(new ShowCardChartPlugin());
        r2.b(new ShowTableDetailPlugin());
        r2.b(new ShowProfilePlugin());
        r2.b(new UpdateStreamingStatePlugin());
        r2.b(new FetchCardPlugin());
        r2.b(new GetAppSettingsPlugin());
        r2.b(new CardGetHostInfoPlugin());
        r2.b(new CardOperateAudioPlugin());
        r2.b(new CardGetAudioStatePlugin());
        r2.b(new CardPreviewVideoPlugin());
        int r3 = com.larksuite.component.card.debugger.b.a;
        ICardDebugger.a.getClass();
        Iterator<OPPlugin> r4 = ((ICardDebugger) ICardDebugger.Companion.b.getValue()).a().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2.b(r4.next());
        goto L7
    L9:
        uy7.a r5 = new uy7.a(r0, r2);
        ((vxb.b) r5).q = r1;
        ayb.a r6 = new ayb.a(r5);
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerBridgeMethodDispatcher("UniversalCard", r6);
        boolean r7 = f.a().isEnable("openplatform.universalcard.v8_engine");
        boolean r8 = k.a(r0);
        LarkLynxKitInitializer.b.a().registerLynxGroup("UniversalCard", new C0128a(r7, r8));
    }

    public a() {
    }
}
