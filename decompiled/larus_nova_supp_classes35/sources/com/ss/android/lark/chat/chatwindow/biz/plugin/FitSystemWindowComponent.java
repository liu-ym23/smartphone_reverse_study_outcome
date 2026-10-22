package com.ss.android.lark.chat.chatwindow.biz.plugin;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/FitSystemWindowComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "customStatusBarStrategy", "Lkotlin/Function0;", BuildConfig.FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function0;)V", "insetsHandler", "Lcom/ss/android/lark/insets/IWindowInsetsHandler;", "hasView", "onCreate", BuildConfig.FLAVOR, "useBottomSheet", "bundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FitSystemWindowComponent extends ChatBaseComponent {
    public final Function0<Boolean> l;
    public f m;

    public static final class a {
    }

    static {
    }

    public FitSystemWindowComponent() {
        this(null);
    }

    public final boolean v0() {
        return false;
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        Fragment r0 = getFragment();
        if (r0 != null) goto L6;
        Log.e("FitSystemWindowComponent", "onCreate: getFragment returns null");
        return;
    L6:
        ChatBaseComponent.a r1 = (ChatBaseComponent.a) u0(ChatBaseComponent.a.class);
        if (r1 == null) goto L11;
        ChatWindowOpenViewModel r2 = r1.c();
        if (r2 == null) goto L11;
        fxa.b r3 = r2.getChatBundle();
    L12:
        f r4 = WindowInsetsUtils.b(r0);
        Function0<Boolean> r5 = this.l;
        if (r5 == null) goto L16;
        boolean r6 = ((Boolean) r5.invoke()).booleanValue();
    L26:
        r4.c(r6);
        r4.o(true);
        this.m = r4;
        return;
    L16:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == false) goto L22;
        if (r3 == null) goto L22;
        if (r3.D() != true) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L25;
        r6 = true;
        goto L26
    L25:
        r6 = false;
    L22:
        r7 = false;
    L11:
        r3 = null;
        goto L12
    }

    public FitSystemWindowComponent(Object r1) {
        this.l = null;
    }
}
