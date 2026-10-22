package s90;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.emoji.EmojiUriModel;
import com.bytedance.android.live.base.model.emoji.EmojiUriNode;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final Pattern b = null;
    public List<BaseEmoji> a;

    static {
        b = PatternProtector.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");
    }

    public a() {
        this.a = null;
    }

    public final List<db2.a> b(CharSequence r6) {
        ArrayList r0 = new ArrayList();
        Matcher r7 = b.matcher(r6);
    L4:
        if (r7.find() == false) goto L11;
        String r1 = r7.group();
        int r2 = r7.start();
        int r3 = r7.end();
        if (k.f(IAwemeEmojiProxy.class) == null) goto L8;
        Drawable r4 = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).getRealDrawable(r1);
    L9:
        if (r4 == null) goto L4;
        r0.add(new db2.a(r4, r2, r3));
        goto L4
    L8:
        r4 = null;
        goto L9
    L11:
        return r0;
    }

    public final List<EmojiUriNode> c(CharSequence r11) {
        ArrayList r0 = new ArrayList();
        Matcher r12 = b.matcher(r11);
    L4:
        if (r12.find() == false) goto L36;
        String r1 = r12.group();
        int r2 = r12.start();
        int r3 = r12.end();
        List<BaseEmoji> r4 = this.a;
        if (r4 == null) goto L10;
        if (r4.isEmpty() == true) goto L10;
    L12:
        List<BaseEmoji> r5 = this.a;
        if (r5 != null) goto L15;
    L33:
        EmojiUriModel r6 = null;
    L34:
        if (r6 == null) goto L4;
        r0.add(new EmojiUriNode(r6, r2, r3));
        goto L4
    L15:
        if (r5.isEmpty() == true) goto L33;
        Iterator<BaseEmoji> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L33;
        BaseEmoji r8 = r7.next();
        if (TextUtils.equals(r8.getDescription(), r1) == false) goto L19;
        int r9 = r8.getIconId();
        String r13 = r8.getLocalFilePath();
        if (r9 > 0) goto L25;
        if (r13 == null) goto L19;
        if (r13.startsWith("file://") == true) goto L30;
    L32:
        r6 = new EmojiUriModel(r9, r13, r1);
        goto L34
    L30:
        if (r13.startsWith("file:///") == true) goto L32;
        r13 = r13.replace("file://", "file:///");
        goto L32
    L25:
        r6 = new EmojiUriModel(r9, r13, r1);
    L10:
        if (k.f(IAwemeEmojiProxy.class) == null) goto L12;
        this.a = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).loadAllBaseEmoji();
        goto L12
    L36:
        return r0;
    }

    public static void a(Spannable r1, Drawable r2, int r3, int r4, int r5, int r6, String r7) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length() == 0) goto L15;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 > r1.length()) goto L17;
        if (r3 <= r4) goto L10;
        return;
    L10:
        if (r4 > r1.length()) goto L19;
        r2.setBounds(0, 0, r5, r6);
        x90.a r8 = new x90.a(r2);
        r8.a = 2;
        r8.b = 2;
        r8.c = r7;
        r1.setSpan(r8, r3, r4, 33);
        return;
    L19:
        return;
    L17:
        return;
    }
}
