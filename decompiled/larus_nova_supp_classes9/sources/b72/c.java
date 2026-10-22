package b72;

import am2.x;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.j;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.l1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public a() {
        }

        public final String toString() {
            return "InputCheckResult{validEndIndex=" + this.a + ", totalCount=" + this.b + ", emojiCount=" + this.c + ", liveEmojiCount=" + this.d + ", liveAssociateImageCount=" + this.e + ", length=0}";
        }
    }

    static {
    }

    public static a a(Editable r13, int r14) {
        if (r13 == null) goto L65;
        String r1 = r13.toString();
        a r2 = new a();
        int r5 = 0;
        e90.a[] r3 = (e90.a[]) r13.getSpans(0, r1.length(), e90.a.class);
        if (r3 != null) goto L7;
    L13:
        List r4 = null;
        e90.a r6 = null;
        int r7 = 0;
    L14:
        char[] r8 = r1.toCharArray();
        int r9 = r7;
        e90.a r10 = r6;
        int r11 = 0;
    L16:
        if (r5 >= r1.length()) goto L59;
        if (l1.b(r8[r5]) == false) goto L25;
        int r15 = r5 + 1;
        if (r15 < r1.length()) goto L22;
    L24:
        r5 = r15;
    L56:
        if (r2.b > r14) goto L16;
        r2.a = r5;
        goto L16
    L22:
        if (l1.b(r8[r15]) == false) goto L24;
        r2.b++;
        r2.c++;
        r5 = r5 + 2;
        goto L56
    L25:
        if (r10 == null) goto L54;
        if (r4 == null) goto L54;
        if (r5 != r9) goto L54;
        int r16 = r10.a();
        if (r16 != 1) goto L31;
    L46:
        r2.b++;
        r2.d++;
        if (r10.getDesc() == null) goto L49;
        String r17 = r10.getDesc();
        Intrinsics.checkNotNull(r17);
        int r18 = r17.length();
    L50:
        r5 = r5 + r18;
        r11 = r11 + 1;
        if (r11 >= r4.size()) goto L53;
        r10 = (e90.a) ListProtector.get(r4, r11);
        r9 = r13.getSpanStart(r10);
        goto L56
    L53:
        r10 = null;
    L49:
        r18 = 4;
        goto L50
    L31:
        if (r16 == 2) goto L46;
        if (r16 != 3) goto L35;
        r2.b++;
        r2.e++;
        if (r10.getDesc() == null) goto L49;
        String r19 = r10.getDesc();
        Intrinsics.checkNotNull(r19);
        r18 = r19.length();
        goto L50
    L35:
        if (r16 == 5) goto L37;
        r2.b++;
        r18 = 1;
        goto L50
    L37:
        r2.b++;
        r2.e++;
        if ((r10 instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == true) goto L40;
        r10 = null;
    L40:
        com.bytedance.android.livesdk.interactivity.comment.input.c r20 = (com.bytedance.android.livesdk.interactivity.comment.input.c) r10;
        if (r20 == null) goto L49;
        r18 = r20.c().length();
    L54:
        r2.b++;
        r5 = r5 + 1;
        goto L56
    L59:
        return r2;
    L7:
        if (r3.length != 0) goto L9;
        boolean r21 = true;
    L11:
        if ((!r21) == false) goto L13;
        r4 = ArraysKt.sortedWith(r3, new d(r13));
        r6 = (e90.a) ListProtector.get(r4, 0);
        r7 = r13.getSpanStart(r6);
        goto L14
    L9:
        r21 = false;
        goto L11
    L65:
        return null;
    }

    public static void b(j r9, com.bytedance.android.live.base.model.message.h r10, String r11, String r13, EditText r14) {
        r9.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r9.layout(0, 0, r9.getMeasuredWidth(), r9.getMeasuredHeight());
        Bitmap r1 = Bitmap.createBitmap(r9.getMeasuredWidth(), r9.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r9.draw(new Canvas(r1));
        BitmapDrawable r4 = new BitmapDrawable(r9.getResources(), r1);
        int r8 = s1.f(24.0f);
        com.bytedance.android.livesdk.interactivity.comment.input.d r2 = new com.bytedance.android.livesdk.interactivity.comment.input.d(r4, r10, r11, (int) ((r1.getWidth() / (r1.getHeight() + 0.0f)) * r8), r8);
        String r15 = r11 + r10.c();
        SpannableStringBuilder r16 = new SpannableStringBuilder(r15);
        if (r15 == null) goto L5;
        Integer r17 = Integer.valueOf(r15.length());
    L6:
        r16.setSpan(r2, 0, r17.intValue(), 33);
        Editable r18 = r14.getEditableText();
        if (r18 == null) goto L14;
        e90.a[] r3 = (e90.a[]) r18.getSpans(0, r18.length(), e90.a.class);
        int r5 = r3.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L14;
        if (r3[r6].a() == 7) goto L12;
        r6 = r6 + 1;
        goto L9
    L12:
        r18.clear();
    L14:
        Editable r19 = r14.getEditableText();
        if (r19 == null) goto L44;
        e90.a[] r7 = (e90.a[]) r19.getSpans(0, r19.length(), e90.a.class);
        int r20 = r7.length;
        int r21 = 0;
    L17:
        if (r21 >= r20) goto L22;
        e90.a r23 = r7[r21];
        if (r23.a() == 6) goto L23;
        r21 = r21 + 1;
    L23:
        if (r23 == null) goto L25;
        int r110 = r19.getSpanStart(r23);
        r19.delete(r110, r19.getSpanEnd(r23));
        r19.insert(r110, r16);
    L26:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.f(r10, r13, true);
        Intrinsics.checkNotNullParameter(r10, "emoji");
        Intrinsics.checkNotNullParameter(r13, "clickArea");
        HashMap r111 = new HashMap();
        r111.put("emoji_type", "quick_interaction");
        if (r10.getType() != 1) goto L29;
        String r112 = "say_hi";
    L30:
        r111.put("quick_interaction_type", r112);
        r111.put("quick_interaction_source", r13);
        MiddlewareRoomContext r113 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L37;
        i r114 = r113.isAnchor();
        if (r114 == null) goto L37;
        if (((Boolean) r114.getValue()).booleanValue() != true) goto L37;
        String r115 = "1";
    L38:
        r111.put("is_anchor", r115);
        j0.l().sendLog("livesdk_input_box_quick_interaction_show", r111, new Object[]{x.class, IRoom.class});
        return;
    L37:
        r115 = "0";
        goto L38
    L29:
        r112 = "location";
        goto L30
    L25:
        r19.insert(r14.getSelectionStart(), r16);
        goto L26
    L22:
        r23 = null;
        goto L23
    L44:
        return;
    L5:
        r17 = null;
        goto L6
    }
}
