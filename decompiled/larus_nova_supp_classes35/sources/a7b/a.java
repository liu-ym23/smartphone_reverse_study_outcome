package a7b;

import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.keyboard.base.p;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final RichText a;
    public final RichText b;
    public final String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public CharSequence h;
    public ScheduleDraftInfo i;
    public p j;
    public PartialReplyInfo k;
    public QueryStatusInfo l;
    public DraftAttachmentSnapshot m;
    public boolean n;
    public b o;

    public a(RichText r3, String r4, RichText r5) {
        this.d = BuildConfig.FLAVOR;
        this.e = 0;
        this.n = false;
        this.o = b.b;
        this.a = r3;
        this.b = r5;
        this.c = r4;
    }
}
