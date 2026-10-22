package hib;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d {
    void a(Context r1, String r2);

    void b(ForwardPickFragment r1);

    void c(Context r1, GifImageView r2, StickImage r3);

    com.ss.android.lark.forwardv2.b d();

    void e(IGetDataCallback r1);

    void f();

    com.ss.android.lark.forwardv2.a g();

    void getEventParams();

    com.ss.android.lark.forwardv2.c getPassportDependency();

    void getTargetType();

    void h(LKUIDialog r1);

    void isEnterSendEnabled();
}
