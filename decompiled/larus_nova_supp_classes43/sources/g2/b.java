package g2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import f2.g;
import f2.j;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import u2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    void A();

    WidgetResourceLoader B(ConversationWidgetData r1);

    void C(g r1);

    void D(Context r1, Bundle r10);

    void E(String r1, boolean r10);

    void F(i r1, Function1<? super GrantingAction, Unit> r10);

    Object G(String r1, Continuation<? super Boolean> r10);

    void H(com.bytedance.ai.applet.login.i r1, Function1<? super GrantingAction, Unit> r10);

    String I(String r1);

    Object J(String r1, Continuation<? super Bitmap> r10);

    void K(Context r1, String r10);

    Pair<Integer, Integer> L(Activity r1);

    void M(m3.d r1, m3.e r10);

    Boolean N(String r1, String r10);

    Activity O();

    Map<String, Object> P();

    void Q(String r1, String r10, boolean r11, Map r12, i r13, DouyinGeneralAuthHelper.b r14);

    int R(String r1);

    void a(Context r1, String r10, com.bytedance.ai.bridge.method.authorize.b r11);

    void b(boolean r1);

    void c(Function2<? super Boolean, ? super String, Unit> r1);

    Activity currentActivity();

    void d(AppletAppActivity r1, int r10, String r11, String r12, Map r13);

    String e();

    String f();

    AIFragmentBase g(String r1);

    Map<String, Object> getSettings();

    int getStatusBarHeight(Context r1);

    a h();

    void i(f r1);

    int j(FragmentActivity r1);

    void k(String r1, String r10);

    Object l(String r1, Continuation<? super Boolean> r10);

    Activity m();

    void n(String r1, String r10, DouyinGeneralAuthHelper.a r11);

    boolean o(Context r1);

    AppletChatInputController p(Context r1);

    void q(String r1, String r10);

    void r(String r1, com.bytedance.ai.applet.douyinAuth.b r10);

    View.OnLongClickListener s(WidgetContainer r1);

    void t(String r1, String r10, String r11, Function1<? super Boolean, Unit> r12);

    void u(j r1);

    boolean v(Context r1);

    void w(f r1);

    boolean x(Activity r1);

    void y(Context r1, String r10, Function1<? super Boolean, Unit> r11);

    Activity z();
}
