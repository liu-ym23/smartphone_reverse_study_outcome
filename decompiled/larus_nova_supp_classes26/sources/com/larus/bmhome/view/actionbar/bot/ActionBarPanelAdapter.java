package com.larus.bmhome.view.actionbar.bot;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.conversation.Templates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarPanelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/im/bean/conversation/Templates;", "Lcom/larus/bmhome/view/actionbar/bot/ActionBarPanelHolder;", "cvsId", "", "dialog", "Landroid/app/Dialog;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "chatPageContextProvider", "Lkotlin/Function0;", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onActionClicked", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Landroid/app/Dialog;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarPanelAdapter extends ListAdapter<Templates, ActionBarPanelHolder> {
    public static final ActionBarPanelAdapter$Companion$DIFF_CALLBACK$1 f = null;
    public final String a;
    public final Dialog b;
    public final ChatParam c;
    public final Function0<ChatPageContext> d;
    public final Function1<String, Unit> e;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.bot.ActionBarPanelAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f = new ActionBarPanelAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final ActionBarPanelHolder r8 = (ActionBarPanelHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final Templates r9 = (Templates) getItem(r7);
        ChatParam r0 = this.c;
        if (r0 == null) goto L5;
        boolean r1 = r0.f;
    L6:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "templates");
        r8.b.setTag(r9);
        r8.b.setText(r9.getTemplateName());
        if (r1 == false) goto L9;
        r8.c.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(((RecyclerView.ViewHolder) r8).itemView.getContext(), v19.c.b(2130968760, ((RecyclerView.ViewHolder) r8).itemView.getContext(), 2131100139))));
    L9:
        ((RecyclerView.ViewHolder) r8).itemView.setOnTouchListener(new i(r8));
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new j(r8, r9));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562486, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ActionBarPanelHolder(r5, new h(this));
    }

    public ActionBarPanelAdapter(String r2, Dialog r3, ChatParam r4, com.larus.bmhome.view.actionbar.bot.a r5, b r6) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Intrinsics.checkNotNullParameter(r6, "onActionClicked");
        super(f);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
