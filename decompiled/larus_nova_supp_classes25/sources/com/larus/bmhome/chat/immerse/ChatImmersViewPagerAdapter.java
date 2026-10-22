package com.larus.bmhome.chat.immerse;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010\u001e\u001a\u00020\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0016J\u0014\u0010&\u001a\u00020\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(J\u0006\u0010)\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingFragment", "loadingPosition", "", "realList", "", "Landroid/os/Bundle;", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "onImmerseRecreate", "Lkotlin/Function1;", "", "getOnImmerseRecreate", "()Lkotlin/jvm/functions/Function1;", "setOnImmerseRecreate", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "createFragment", "position", "showLoading", "hideLoading", "replaceLoading", "getItemId", "", "getHashCode", "bundle", "containsItem", "", "itemId", "updateData", "botList", "", "hasLoading", "DiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatImmersViewPagerAdapter extends FragmentStateAdapter {
    public static final /* synthetic */ int g = 0;
    public final Fragment a;
    public final AtomicBoolean b;
    public final LoadingFragment c;
    public int d;
    public List<Bundle> e;
    public Function1<? super Bundle, Unit> f;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersViewPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Landroid/os/Bundle;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getHashCode", "", "bundle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<Bundle> a;
        public final List<Bundle> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public static long a(Bundle r3) {
            Intrinsics.checkNotNullParameter(r3, "bundle");
            String r0 = r3.getString("argBotId");
            int r1 = 0;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L11;
            int r4 = r0.hashCode();
        L22:
            return r4;
        L11:
            if (r3.getBoolean("loading", false) == false) goto L13;
            r4 = 336650556;
            goto L22
        L13:
            String r5 = r3.getString("argConversationId");
            if (com.larus.utils.o0.d(r5) == false) goto L19;
            if (r5 == null) goto L18;
            r1 = r5.hashCode();
        L18:
            return r1;
        L19:
            r4 = 1544803905;
            goto L22
        L5:
            if (r0.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public DiffCallback(List<Bundle> r2, List<Bundle> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            if (a((Bundle) ListProtector.get(this.a, r4)) != a((Bundle) ListProtector.get(this.b, r5))) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean areItemsTheSame(int r4, int r5) {
            if (a((Bundle) ListProtector.get(this.a, r4)) != a((Bundle) ListProtector.get(this.b, r5))) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class a {
    }

    static {
    }

    public final List<Bundle> z2() {
        List<Bundle> r0 = this.e;
        Bundle r1 = this.a.getArguments();
        if (r1 != null) goto L6;
        r1 = new Bundle();
    L6:
        if (r0.contains(r1) == true) goto L19;
        Bundle r2 = this.a.getArguments();
        if (r2 == null) goto L12;
        boolean r3 = true;
        if (r2.getBoolean("enter_from_discovery") != true) goto L12;
    L13:
        if (r3 == true) goto L19;
        List<Bundle> r4 = this.e;
        Bundle r5 = this.a.getArguments();
        if (r5 != null) goto L17;
        r5 = new Bundle();
    L17:
        ListProtector.add(r4, 0, r5);
    L12:
        r3 = false;
    L19:
        return this.e;
    }

    public final int getItemCount() {
        return z2().size();
    }

    public ChatImmersViewPagerAdapter(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        super(r6);
        this.a = r6;
        this.b = new AtomicBoolean(false);
        LoadingFragment r0 = new LoadingFragment();
        Bundle r2 = r0.getArguments();
        if (r2 == null) goto L5;
        i0 r3 = i0.a;
        r2.putInt("immerseOrientation", i0.c());
    L5:
        this.c = r0;
        this.d = -1;
        Bundle[] r1 = new Bundle[1];
        Bundle r7 = r6.getArguments();
        if (r7 != null) goto L8;
        r7 = new Bundle();
    L8:
        r1[0] = r7;
        this.e = CollectionsKt.mutableListOf(r1);
        this.f = new h0();
    }

    public static long y2(Bundle r3) {
        String r0 = r3.getString("argBotId");
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        int r4 = r0.hashCode();
    L22:
        return r4;
    L11:
        if (r3.getBoolean("loading", false) == false) goto L13;
        r4 = 336650556;
        goto L22
    L13:
        String r5 = r3.getString("argConversationId");
        if (com.larus.utils.o0.d(r5) == false) goto L19;
        if (r5 == null) goto L18;
        r1 = r5.hashCode();
    L18:
        return r1;
    L19:
        r4 = 1544803905;
        goto L22
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean containsItem(long r8) {
        List<Bundle> r0 = z2();
        ListIterator<Bundle> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L11;
        Bundle r2 = r1.previous();
        if (y2(r2) != r8) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L13:
        if (r2 == null) goto L21;
        return true;
    L21:
        return false;
    L8:
        r4 = false;
        goto L9
    L11:
        r2 = null;
        goto L13
    }

    public final Fragment createFragment(int r19) {
        FLogger r2 = FLogger.a;
        r2.i("immersAdapter", "createFragment: " + r19);
        boolean r7 = false;
        if (((Bundle) ListProtector.get(z2(), r19)).getBoolean("loading", false) == false) goto L5;
        r2.i("immersAdapter", "createFragment: " + r19 + ", loading");
        return this.c;
    L5:
        r2.i("immersAdapter", "createFragment: " + r19 + ", chat");
        boolean r3 = this.a.getActivity() instanceof ChatImmersActivity;
        boolean r4 = ChatFragment.N;
        Bundle r5 = (Bundle) ListProtector.get(z2(), r19);
        ChatImmersFragment r6 = this.a;
        if ((r6 instanceof ChatImmersFragment) == false) goto L8;
        ChatImmersFragment r8 = r6;
    L10:
        if (r8 == null) goto L15;
        if (r8.B != true) goto L15;
        r7 = true;
    L15:
        if (r7 == true) goto L17;
        i0 r9 = i0.a;
        r5.putInt("immerseOrientation", i0.c());
    L17:
        r5.putBoolean("is_in_immers_fragment", true);
        r5.putInt("argImmersPosition", r19);
        if (r19 == 0) goto L20;
        r5.putString("enter_method", "slide_in_immersive");
    L27:
        final ChatFragment r1 = new ChatFragment();
        r1.e = r5;
        if (r3 == true) goto L30;
    L55:
        if (r3 == true) goto L68;
        r1.g = new d0(r1, this);
        r1.h = new e0(this);
        Function1<? super Bundle, Unit> r0 = new f0(this);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r1.p = r0;
        ChatImmersFragment r10 = this.a;
        if ((r10 instanceof ChatImmersFragment) == false) goto L60;
        ChatImmersFragment r11 = r10;
    L61:
        if (r11 == null) goto L63;
        Function1<? super Fragment, Unit> r12 = r11.o;
    L64:
        if (r12 == null) goto L69;
        r1.f = new g0(this);
        return r1;
    L69:
        return r1;
    L63:
        r12 = null;
        goto L64
    L60:
        r11 = null;
        goto L61
    L68:
        return r1;
    L30:
        if (z2.a.enableTopLeftMainBotUnclick() == false) goto L55;
        Bundle r13 = new Bundle();
        boolean r14 = r5.getBoolean("argCvsBgImgOpen");
        if (r14 == false) goto L34;
        String r15 = r5.getString("argCvsBgImgUrl");
    L36:
        if (r14 == false) goto L38;
        String r16 = r5.getString("argCvsBgImgColor");
    L39:
        if (r14 == false) goto L41;
        Integer r17 = Integer.valueOf(r5.getInt("immerseOrientation"));
    L43:
        if (r14 == false) goto L45;
        String r18 = r5.getString("argCvsBgVideoModel");
    L46:
        Boolean r110 = Boolean.valueOf(r5.getBoolean("is_in_immers_fragment"));
        String r20 = r5.getString("argConversationId");
        r13.putBoolean("argCvsBgImgOpen", r14);
        r13.putString("argCvsBgImgUrl", r15);
        r13.putString("argCvsBgImgColor", r16);
        if (r17 == null) goto L49;
        r13.putInt("immerseOrientation", r17.intValue());
    L49:
        r13.putString("argCvsBgVideoModel", r18);
        if (r110 == null) goto L52;
        r13.putBoolean("is_in_immers_fragment", r110.booleanValue());
    L52:
        if (r20 == null) goto L54;
        r13.putString("argConversationId", r20);
    L54:
        r1.setArguments(r13);
        goto L55
    L45:
        r18 = null;
        goto L46
    L41:
        r17 = -1;
        goto L43
    L38:
        r16 = null;
        goto L39
    L34:
        r15 = null;
        goto L36
    L20:
        Bundle r21 = this.a.getArguments();
        if (r21 == null) goto L23;
        String r22 = r21.getString("enter_method");
    L25:
        if (com.larus.utils.o0.d(r22) == false) goto L27;
        r5.putString("enter_method", r22);
        goto L27
    L23:
        r22 = null;
        goto L25
    L8:
        r8 = null;
        goto L10
    }

    public final long getItemId(int r3) {
        return y2((Bundle) ListProtector.get(z2(), r3));
    }
}
