package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.app.NoteEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\r*\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/NoteViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "stripMarkup", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoteViewHolder extends AbsCardItemTitleContentStyle<NoteEntity> {
    public NoteViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r13) {
        NoteEntity r14 = (NoteEntity) r13;
        Intrinsics.checkNotNullParameter(r14, "entity");
        String r0 = r14.getTitle();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = r14.getText();
    L8:
        String r2 = r14.getText();
        if (StringsKt.indexOf$default(r2, r0, 0, false, 6, null) != 0) goto L11;
        r2 = r2.substring(r0.length());
    L11:
        AppEntityListAdapter.PageType r6 = null;
        lca.a r4 = new lca.a(2131244469, null, 6);
        String r3 = StringsKt.trim(r0, new char[]{' ', '\n'});
        Regex r5 = new Regex("<image\\s+w=.*?\\s+h=.*?\\s+describe=.*?\\s+name=.*?>");
        String r7 = StringsKt.trim(new Regex("<audio\\s+name=([^\\s>]+)[^>]*>").replace(r5.replace(r2, getContext().getString(2131912011) + '\n'), getContext().getString(2131912010) + '\n'), new char[]{' ', '\n'});
        AppEntityListAdapter.PageType r8 = this.f;
        if (r8 == null) goto L14;
        r6 = r8;
    L16:
        if (r6 != AppEntityListAdapter.PageType.ShowAllPage) goto L22;
        int r9 = com.obric.assistant.card.utils.j.a;
        long r10 = r14.getCreateTime();
        Calendar r15 = Calendar.getInstance();
        r15.setTimeInMillis(r10);
        Intrinsics.checkNotNull(r15);
        if (com.obric.assistant.card.utils.j.e(r15, Calendar.getInstance()) == false) goto L20;
        String r16 = "MM/dd";
    L21:
        String r17 = new SimpleDateFormat(r16, Locale.getDefault()).format(new Date(r10));
    L24:
        return new AbsCardItemTitleContentStyle.a(r4, 0, r3, r7, r17);
    L20:
        r16 = "yyyy/MM/dd";
        goto L21
    L22:
        int r11 = com.obric.assistant.card.utils.j.a;
        r17 = com.obric.assistant.card.utils.j.c(getContext(), r14.getCreateTime());
        goto L24
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        goto L16
    L5:
        r1 = false;
        goto L6
    }
}
