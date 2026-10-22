package trb;

import com.ss.android.lark.message.vote.message.VoteMessageCell;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final RichText a;
    public final qrb.a b;
    public final irb.b c;
    public final a d;

    public class a extends e {
        public final /* synthetic */ c a;

        public final void J(RichTextElement.MediaProperty r1) {
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void H(RichTextElement.ProgressSelectOptionProperty r3) {
            irb.a r0 = new irb.a();
            r0.a = r3.getActionId();
            r0.b = r3.getActionParamName();
            r0.c = r3.getActionParamValue();
            r0.d = r3.isDisable();
            r0.e = r3.isSelected();
            r0.f = r3.getOptionCase();
            r0.g = r3.getContent();
            r0.h = r3.getNumberOfSelected();
            r0.i = r3.getNumberOfTotal();
            ((ArrayList) this.a.c.c).add(r0);
        }

        public final void a(RichText r2) {
            c r3 = this.a;
            qrb.a r0 = r3.b;
            if (r0 == null) goto L6;
            VoteMessageCell.a r1 = (VoteMessageCell.a) r0;
            r1.a(r3.c);
            return;
        }

        public final void b(RichText r1) {
            qrb.a r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.getClass();
            return;
        }

        public final void e(RichTextElement.SelectProperty r3) {
            irb.b r0 = this.a.c;
            r0.b = r3.getMaxPickNum();
            irb.b r1 = this.a.c;
            r3.getMinPickNum();
            r1.getClass();
        }

        public final void y(RichTextElement.ButtonProperty r2) {
            irb.b r0 = this.a.c;
            r0.d = r2.getActionId();
        }

        public final void N(RichTextElement.TextProperty r1, Map<String, String> r2) {
            irb.b r3 = this.a.c;
            String r4 = r1.getContent();
            ((ArrayList) r3.a).add(r4);
        }
    }

    public c(RichText r2, VoteMessageCell.a r3) {
        this.c = new irb.b();
        this.d = new a(this);
        this.a = r2;
        this.b = r3;
    }
}
