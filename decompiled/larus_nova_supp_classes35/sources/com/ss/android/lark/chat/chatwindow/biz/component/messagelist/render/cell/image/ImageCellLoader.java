package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ImageContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.m;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.ChatImageErrDetector;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.utils.g;
import com.ss.android.lark.chat.utils.v;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.ByteString;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ImageCellLoader {
    public static final /* synthetic */ int e = 0;
    public final m2b.a a;
    public f b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
        @JvmStatic
        public static ImageSet a(ImageContentVO r8) {
            Intrinsics.checkNotNullParameter(r8, "<this>");
            return new ImageSet((String) r8.h.getValue(), (Image) r8.i.getValue(), (Image) r8.k.getValue(), (Image) r8.l.getValue(), (ByteString) r8.m.getValue(), r8.n);
        }

        @JvmStatic
        public static Image b(ImageContentVO r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return g.b(a(r1));
        }
    }

    public static final class b implements ListenerParams.b {
        public final m2b.a a;
        public final c b;
        public final com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a c;
        public final String d;
        public final String e;
        public final v f;
        public final Lazy g;

        public final void a(Exception r12) {
            Log.e("ImageCellLoader", "image load failed, messageId=" + this.d + ", imageKey=" + this.e, r12);
            ChatImageErrDetector r13 = (ChatImageErrDetector) this.g.getValue();
            String r0 = this.d;
            String r1 = this.e;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r0, "msgId");
            if (r1 == null) goto L6;
            ((ConcurrentHashMap) ChatImageErrDetector.a).put(new ChatImageErrDetector.b(r0, r1), Boolean.FALSE);
            ChatImageErrDetector.b.put(new ChatImageErrDetector.b(r0, r1), AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Chat, Event.image_load_real_failed, "ChatWindowActivity", true));
            UICallbackExecutor.executeDelayed(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.a(r13, r0, r1), 1500);
        L6:
            v r14 = this.f;
            if (r14 == null) goto L10;
            r14.onFinish();
            return;
        }

        public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            Log.i("ImageCellLoader", "image load success, messageId=" + this.d + ", imageKey=" + this.e);
            ThreadUtils.runOnUIThread(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.b(r1, this));
            ChatImageErrDetector r5 = (ChatImageErrDetector) this.g.getValue();
            String r6 = this.d;
            String r7 = this.e;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "msgId");
            if (r7 == null) goto L9;
            ConcurrentHashMap r8 = (ConcurrentHashMap) ChatImageErrDetector.a;
            if (r8.containsKey(new ChatImageErrDetector.b(r6, r7)) == false) goto L9;
            r8.put(new ChatImageErrDetector.b(r6, r7), Boolean.TRUE);
        L9:
            v r9 = this.f;
            if (r9 == null) goto L13;
            r9.onFinish();
            return;
        }

        public b(m2b.a r2, ImageContentBlock.b r3, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a r4, String r5, String r6, m r7) {
            Intrinsics.checkNotNullParameter(r2, "chatContext");
            Intrinsics.checkNotNullParameter(r3, "holder");
            Intrinsics.checkNotNullParameter(r4, "imageInfo");
            Intrinsics.checkNotNullParameter(r5, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = LazyKt.lazy(ImageCellLoader$GifRequestListener$chatImageErrDetector$2.INSTANCE);
        }
    }

    public interface c {
        MarkView a();
    }

    static {
    }

    public ImageCellLoader(m2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ImageCellLoader$holderCal$2(this));
        this.d = LazyKt.lazy(ImageCellLoader$chatImageErrDetector$2.INSTANCE);
    }

    public final int a(y6b.a<ImageContentVO> r8, v4b.d r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        lya.a r0 = this.a.l();
        y6b.c r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.a();
    L6:
        int r3 = UIHelper.dp2px(680.0f);
        boolean r4 = false;
        int r5 = 0;
        if (r9 == null) goto L9;
        int r6 = r9.d;
    L10:
        if (r6 <= 0) goto L14;
        if (r9 == null) goto L47;
        r5 = r9.d;
    L47:
        return RangesKt.coerceAtMost(r3, r5);
    L14:
        if (this.a.q() == false) goto L22;
        if ((r8 instanceof y6b.c) == true) goto L18;
    L20:
        r5 = j.l(this.a.getContext(), f3b.b.a(this.a));
        goto L47
    L18:
        if (((y6b.c) r8).W2 != (-1)) goto L20;
        r5 = j.k(this.a.getContext(), f3b.b.a(this.a));
        goto L47
    L22:
        if (this.a.r() == false) goto L25;
        r5 = j.b(this.a.getContext(), f3b.b.a(this.a));
        goto L47
    L25:
        if (this.a.m() == false) goto L37;
        FragmentActivity r10 = this.a.getContext();
        Integer r7 = f3b.b.a(this.a);
        boolean r11 = r8 instanceof y6b.c;
        if (r11 == false) goto L29;
        y6b.c r12 = (y6b.c) r8;
    L30:
        boolean r13 = q7b.c.a(r12, this.a);
        if (r11 == false) goto L33;
        r1 = (y6b.c) r8;
    L33:
        if (r1 == null) goto L35;
        r4 = r1.V1;
    L35:
        r5 = j.e(r10, r7, r13, r4);
        goto L47
    L29:
        r12 = null;
        goto L30
    L37:
        if (this.a.Y() == true) goto L39;
        r5 = j.d(this.a.getContext(), r2);
        goto L47
    L39:
        if ((r8 instanceof y6b.c) == false) goto L44;
        y6b.c r14 = (y6b.c) r8;
        if (r14.Y() == false) goto L43;
        r5 = j.i(this.a.getContext(), r14.V1, f3b.b.a(this.a), q7b.c.a(r14, this.a));
        goto L47
    L43:
        r5 = j.j(this.a.getContext(), r14.V1, f3b.b.a(this.a), q7b.c.a(r14, this.a));
        goto L47
    L44:
        r5 = j.d(this.a.getContext(), r2);
        goto L47
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
