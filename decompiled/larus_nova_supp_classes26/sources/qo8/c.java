package qo8;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.view.share.ConversationMessageListItemDecoration;
import com.larus.bmhome.chat.view.share.ConversationShareMessageListAdapter;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class c implements e {
    public final List<Message> a;
    public final String b;
    public final Bitmap c;
    public final wc9.e d;
    public final MessageShareViewModel.b e;
    public final Bitmap f;
    public final boolean g;
    public ConversationShareMessageListAdapter h;
    public final Lazy i;
    public final Lazy j;

    public abstract void c(Context r1);

    public abstract void e();

    public abstract void f(Context r1);

    public abstract void g();

    public final int d() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final void h(Context r7, boolean r8) {
        ConstraintLayout r0 = b();
        if (r0 == null) goto L40;
        r0.setTag(2131388104, this.e.f());
        if (r8 == false) goto L9;
        ConstraintLayout r9 = r0.findViewById(2131379973);
        if (r9 == null) goto L9;
        r9.setPadding(r9.getPaddingLeft(), i5.h(), r9.getPaddingRight(), 0);
    L9:
        MaxHeightRecyclerView r10 = r0.findViewById(2131379998);
        if (r10 != null) goto L12;
        return;
    L12:
        if (this.g == false) goto L14;
        int r1 = (com.larus.utils.i.d(r7) * 4) / 5;
        r10.setMinimumHeight(r1);
        r10.setMaxHeight(r1);
    L14:
        r10.setLayoutManager(new LinearLayoutManager(r7));
        r10.addItemDecoration(new ConversationMessageListItemDecoration(0));
        ConversationShareMessageListAdapter r11 = new ConversationShareMessageListAdapter(this.e.g().m());
        List<Message> r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "messageList");
        List<Message> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L35;
        Message r6 = (Message) r5.next();
        List r12 = com.larus.bmhome.chat.bean.d.K(r6);
        if (r12 == null) goto L22;
        boolean r13 = true;
        if ((!((ArrayList) r12).isEmpty()) != true) goto L22;
    L23:
        if (r13 == false) goto L34;
        List r14 = (List) r11.h.getValue();
        if (r14 == null) goto L27;
        List r15 = CollectionsKt.toMutableList(r14);
    L28:
        if (r15 == null) goto L33;
        String r16 = r6.getMessageId();
        if (r16 != null) goto L32;
        r16 = "";
    L32:
        r15.add(r16);
    L33:
        r11.h.setValue(r15);
        goto L34
    L27:
        r15 = null;
    L34:
        CopyOnWriteArraySet r17 = xc8.f.a;
        r4.add(xc8.f.e(r6, new d()));
    L22:
        r13 = false;
        goto L23
    L35:
        r11.D2(r4);
        this.h = r11;
        r10.setAdapter(r11);
        return;
    }

    public c(Context r2, List<Message> r3, String r4, Bitmap r5, wc9.e r6, MessageShareViewModel.b r7, Bitmap r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageList");
        Intrinsics.checkNotNullParameter(r7, "provider");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.i = LazyKt.lazy(new a());
        this.j = LazyKt.lazy(new b());
        c(r2);
        if (r9 == false) goto L5;
        h(r2, true);
        return;
    L5:
        e();
        ConstraintLayout r10 = b();
        if (r10 == null) goto L25;
        Group r11 = r10.findViewById(2131374290);
        if (r11 == null) goto L10;
        e1.x(r11);
    L10:
        ImageView r12 = (ImageView) r10.findViewById(2131374278);
        if (r12 == null) goto L17;
        if (r5 != null) goto L14;
    L16:
        r12.setImageResource(2131240119);
        goto L17
    L14:
        if (r5.isRecycled() == true) goto L16;
        r12.setImageBitmap(r5);
    L17:
        TextView r13 = (TextView) r10.findViewById(2131388772);
        if (r13 == null) goto L25;
        if (r6 == null) goto L23;
        String r14 = r6.c;
        if (r14 == null) goto L23;
    L24:
        r13.setText(r14);
    L23:
        r14 = "";
    L25:
        h(r2, false);
        g();
        f(r2);
    }
}
