package q9b;

import android.view.View;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupAdapter;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends OnSingleClickListener {
    public final /* synthetic */ ContactsMyGroupAdapter a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ AvatarItemView c;

    public final void onSingleClick(View r5) {
        int r6 = this.a.getIndex(this.b);
        Lazy r0 = ContactHitPoint.a;
        Intrinsics.checkNotNullParameter("groups_i_manage", "source");
        Intrinsics.checkNotNullParameter("group", "itemType");
        Statistics.sendEvent("larkw_picker_item_click", new JSONObject().put("source", "groups_i_manage").put("item_type", "group").put("order", r6).put("breadcrumb_depth", 1));
        String r7 = this.b.getId();
        this.a.b.contains(r7);
        this.a.getClass();
        ContactsMyGroupAdapter r8 = this.a;
        this.c.getContext();
        r8.getClass();
        ContactsMyGroupAdapter r9 = this.a;
        r9.getClass();
        ContactsMyGroupAdapter.b r1 = r9.d;
        if (r1 == null) goto L6;
        r1.a(this.b, ContactsMyGroupAdapter.y2(r9).indexOf(this.b));
        return;
    }

    public c(ContactsMyGroupAdapter r1, Chat r2, AvatarItemView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(500);
    }
}
