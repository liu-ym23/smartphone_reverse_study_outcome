package ke8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.mainbot.impl.databinding.LarusCotDetailUserUploadCellBinding;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends le8.a<he8.f> {
    public final Lazy b;
    public int c;
    public int d;
    public Message e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    private final LarusCotDetailUserUploadCellBinding getBinding() {
        return (LarusCotDetailUserUploadCellBinding) this.b.getValue();
    }

    private final UplinkTextMenuController getMenuController() {
        return (UplinkTextMenuController) this.f.getValue();
    }

    @Override // le8.a
    public final void b() {
        UplinkTextMenuController r0 = getMenuController();
        r0.j++;
        r0.e();
        r0.h = null;
        r0.i = null;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onViewRecycled=messageId=");
        Message r3 = this.e;
        if (r3 == null) goto L5;
        String r4 = r3.getMessageId();
    L6:
        r2.append(r4);
        r2.append(", sizeChangedWidth=");
        r2.append(this.d);
        r2.append(", sizeChangedHeight=");
        r2.append(this.c);
        r1.i("UplinkTextView", r2.toString());
        this.e = null;
        this.d = 0;
        this.c = 0;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        UplinkTextMenuController r0 = getMenuController();
        r0.j++;
        r0.e();
        super.onDetachedFromWindow();
    }

    public c0(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = LazyKt.lazy(new a0(r3, this));
        this.f = LazyKt.lazy(new b0(this));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView r4 = getBinding().b;
        Intrinsics.checkNotNull(r4);
        r4.setTextSize(0, we8.a.a(i5.t(), false));
        r4.setLineSpacing(0.0f, 1.1f);
    }

    public static UplinkTextMenuController c(c0 r2) {
        return new UplinkTextMenuController(r2.getBinding().b, r2.getBinding().c);
    }

    @Override // le8.b
    public final void a(ie8.a r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        kc8.y r0 = r9.c;
        Integer r1 = null;
        if (r0 == null) goto L5;
        kc8.y.a r2 = r0.b();
        r2.g = getAttachedRecyclerView();
        kc8.y r3 = r2.a();
    L6:
        UplinkTextMenuController r4 = getMenuController();
        Message r5 = r9.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        r4.j++;
        r4.e();
        r4.h = r5;
        r4.i = r3;
        Block r6 = (Block) CollectionsKt.firstOrNull(com.larus.im.bean.message.a.d(r9.a));
        if (r6 == null) goto L13;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L13;
        TextBlock r8 = r7.getTextBlock();
        if (r8 == null) goto L13;
        String r10 = r8.text;
    L14:
        this.e = r9.a;
        getBinding().b.setText(r10);
        IFlowThemeConfigProvider r11 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r11 == null) goto L17;
        r11.d(getBinding().b, ThemeColorKey.MESSAGE_SEND_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT);
    L17:
        FrameLayout r12 = getBinding().c;
        Drawable r13 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970743, getContext(), 2131239374));
        if (r13 == null) goto L22;
        IFlowThemeConfigProvider r14 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r14 == null) goto L23;
        IFlowThemeConfigProvider.a.a(r14, r13, ThemeColorKey.MESSAGE_BUBBLE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE);
    L23:
        r12.setBackground(r13);
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("bindData,mesageid:");
        r16.append(r9.a.getMessageId());
        r16.append(" content.length: ");
        if (r10 == null) goto L26;
        r1 = Integer.valueOf(r10.length());
    L26:
        r16.append(r1);
        r15.i("UplinkTextView", r16.toString());
        return;
    L22:
        r13 = null;
    L13:
        r10 = null;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d = r1;
        this.c = r2;
    }
}
