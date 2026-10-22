package com.larus.bmhome.view.actionbar.bot;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.databinding.LarusFragmentDraggableDialogBinding;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.conversation.Templates;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.w0;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\f\u0010%\u001a\u00020\u0019*\u00020\u0007H\u0002J\u000f\u0010&\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010'J\u001a\u0010*\u001a\u00020\u00192\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190)J\b\u0010,\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentDraggableDialogBinding;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/larus/bmhome/view/actionbar/bot/ActionBarPanelAdapter;", "lastItemCount", "", "cvsId", "", "param", "Lcom/larus/bmhome/chat/ChatParam;", "lang", "model", "Lcom/larus/bmhome/view/actionbar/bot/ActionBarViewModel;", "itemAlreadyFullyVisibleMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViewModel", "checkItemFullVisibility", "isColdStart", "()Ljava/lang/Boolean;", "onActionClickCallback", "Lkotlin/Function1;", "setActionClickCallback", "callback", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarDialogFragment extends BottomSheetDialogFragment {
    public static final CopyOnWriteArraySet<String> n = null;
    public LarusFragmentDraggableDialogBinding d;
    public RecyclerView e;
    public ActionBarPanelAdapter f;
    public int g;
    public String h;
    public ChatParam i;
    public String j;
    public ActionBarViewModel k;
    public final HashMap<Long, Boolean> l;
    public Function1<? super String, Unit> m;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
        n = new CopyOnWriteArraySet();
    }

    public final Boolean T90() {
        String r0 = this.h;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return null;
    L13:
        return Boolean.valueOf(!n.contains(this.h));
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void onDestroy() {
        n.add(this.h);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public ActionBarDialogFragment() {
        this.l = new HashMap();
    }

    public final void S90(RecyclerView r15) {
        FLogger.a.i("ActionBarDialogFragment", "checkItemFullVisibility");
        int r0 = r15.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L61;
        View r2 = r15.getChildAt(r1);
        TextView r3 = (TextView) r2.findViewById(2131388315);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = r3.getTag();     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.im.bean.conversation.Templates");     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl((Templates) r5);     // Catch: Throwable -> L7
    L9:
        String r7 = null;
        if (Result.isFailure-impl(r6) == false) goto L12;
        r6 = null;
    L12:
        Templates r8 = (Templates) r6;
        if (r8 == null) goto L17;
        Long r9 = r8.getId();
        if (r9 == null) goto L17;
        long r10 = r9.longValue();
    L18:
        int r11 = w0.a;
        if (w0.d(r2) == true) goto L21;
        this.l.put(Long.valueOf(r10), Boolean.FALSE);
    L60:
        r1 = r1 + 1;
        goto L3
    L21:
        if (Intrinsics.areEqual(this.l.get(Long.valueOf(r10)), Boolean.TRUE) == true) goto L60;
        ChatParam r12 = this.i;
        if (r12 == null) goto L25;
        String r13 = r12.b;
    L26:
        if (r12 == null) goto L30;
        String r14 = r12.a;
        if (r14 == null) goto L30;
        Long r16 = Long.valueOf(k.a(r14));
    L31:
        if (r8 == null) goto L33;
        String r17 = r8.getRequestId();
    L34:
        ChatParam r18 = this.i;
        if (r18 == null) goto L37;
        String r19 = r18.c;
    L38:
        if (r18 == null) goto L40;
        r7 = r18.d;
    L40:
        Long r110 = Long.valueOf(r10);
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r13 != null) goto L62;
    L45:
        if (r16 == null) goto L47;
        r111.put(MusicAppletPage.KEY_CONVERSATION_ID, r16.longValue());     // Catch: JSONException -> L43
    L47:
        if (r7 == null) goto L49;
        r111.put("current_page", r7);     // Catch: JSONException -> L43
    L49:
        if (r19 == null) goto L51;
        r111.put("previous_page", r19);     // Catch: JSONException -> L43
    L51:
        r111.put("recommend_from", "chat_action_bar_discover");     // Catch: JSONException -> L43
        if (r17 == null) goto L54;
        r111.put("req_id", r17);     // Catch: JSONException -> L43
    L54:
        if (r110 == null) goto L58;
        r111.put("template_id", r110.longValue());     // Catch: JSONException -> L43
    L58:
        TrackParams r20 = new TrackParams().merge(r111);
        by7.a r21 = new by7.a("chat_action_bar_discover_show");
        r21.a.merge(r20);
        r21.b();
        this.l.put(Long.valueOf(r10), Boolean.TRUE);
        goto L60
    L62:
        r111.put("bot_id", r13);     // Catch: JSONException -> L43
    L43:
        e = move-exception;
        FLogger.a.e("ChatEventHelper", "error in ChatEventHelper chatActionBarDiscoverShow " + e.getLocalizedMessage());
        goto L58
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
    L30:
        r16 = null;
        goto L31
    L25:
        r13 = null;
    L17:
        r10 = 0;
    L7:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954335);
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
        return;
    L5:
        this.h = r4.getString("key_conversation_id");
        this.i = r4.getParcelable("key_chat_param");
        Bundle r5 = getArguments();
        if (r5 == null) goto L8;
        String r6 = r5.getString("key_language");
    L9:
        this.j = r6;
        this.k = (ActionBarViewModel) new ViewModelProvider(this, new ActionBarViewModelFactory(this.j)).get(ActionBarViewModel.class);
        return;
    L8:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.view.actionbar.bot.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.view.actionbar.bot.b] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        ActionBarViewModel r10 = this.k;
        if (r10 == null) goto L5;
        r10.loadData(T90());
    L5:
        String r1 = this.h;
        RecyclerView r11 = null;
        if (r1 == null) goto L17;
        Dialog r2 = getDialog();
        Intrinsics.checkNotNull(r2);
        this.f = new ActionBarPanelAdapter(r1, r2, this.i, new com.larus.bmhome.view.actionbar.bot.a(this), new com.larus.bmhome.view.actionbar.bot.b(this));
        LarusFragmentDraggableDialogBinding r0 = this.d;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L10:
        RecyclerView r3 = r0.e;
        this.e = r3;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r3 = null;
    L13:
        r3.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r4 = this.e;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r4 = null;
    L16:
        r4.setAdapter(this.f);
    L17:
        Dialog r5 = getDialog();
        if (r5 == null) goto L20;
        View r6 = r5.findViewById(2131368870);
    L21:
        if (r6 == null) goto L23;
        r6.setBackgroundResource(R.color.transparent);
    L23:
        BottomSheetBehavior.from(r6).setState(3);
        if (r6 == null) goto L26;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L27:
        if (r7 == null) goto L29;
        int r12 = m0.a;
        r7.height = (int) (m0.a(getContext()) * 0.7f);
    L29:
        if (r6 == null) goto L31;
        r6.setLayoutParams(r7);
    L31:
        ViewGroup r13 = this.e;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L34:
        r13.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        RecyclerView r14 = this.e;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L38:
        r11.addOnScrollListener(new AnonymousClass3(this));
        ActionBarViewModel r15 = this.k;
        if (r15 == null) goto L43;
        MutableLiveData<List<Templates>> r16 = r15.getNewPageList();
        if (r16 == null) goto L43;
        r16.observe(getViewLifecycleOwner(), new b(new d(this)));
    L43:
        ActionBarViewModel r17 = this.k;
        if (r17 == null) goto L48;
        MutableLiveData<List<Templates>> r18 = r17.getDataList();
        if (r18 == null) goto L48;
        r18.observe(getViewLifecycleOwner(), new b(new e(this)));
    L48:
        ActionBarViewModel r19 = this.k;
        if (r19 == null) goto L54;
        MutableLiveData<Boolean> r20 = r19.getDataLoading();
        if (r20 == null) goto L55;
        r20.observe(getViewLifecycleOwner(), new b(new f(this)));
        return;
    L55:
        return;
    L54:
        return;
    L37:
        r11 = r14;
        goto L38
    L26:
        r7 = null;
        goto L27
    L20:
        r6 = null;
        goto L21
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562381, r8, false);
        int r11 = 2131364392;
        if (ViewBindings.findChildViewById(r10, 2131364392) == null) goto L15;
        r11 = 2131369197;
        View r2 = ViewBindings.findChildViewById(r10, 2131369197);
        if (r2 == null) goto L15;
        r11 = 2131378952;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131378952);
        if (r3 == null) goto L15;
        r11 = 2131378981;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131378981);
        if (r4 == null) goto L15;
        r11 = 2131384071;
        RecyclerView r5 = ViewBindings.findChildViewById(r10, 2131384071);
        if (r5 == null) goto L15;
        ConstraintLayout r12 = r10;
        this.d = new LarusFragmentDraggableDialogBinding(r12, r2, r3, r4, r5);
        return r12;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
