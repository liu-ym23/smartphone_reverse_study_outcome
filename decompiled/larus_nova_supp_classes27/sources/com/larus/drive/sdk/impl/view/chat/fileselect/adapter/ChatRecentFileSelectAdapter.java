package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import com.larus.drive.sdk.api.file.select.ChatRecentFileSource;
import com.larus.drive.sdk.impl.utils.m;
import com.larus.drive.sdk.impl.view.chat.fileselect.data.ChatRecentFileLoadProcessor;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.api.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001f\u0018\u0000 F2\u00020\u0001:\u0002FGB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020)H\u0016J\u0006\u00100\u001a\u00020\"J\u0006\u00101\u001a\u00020\"J\b\u00102\u001a\u00020\u0012H\u0002J\u0006\u00103\u001a\u00020\"J\b\u00104\u001a\u00020\u0014H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d06H\u0002J\u0016\u00107\u001a\u00020\"2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d06H\u0002J\b\u00109\u001a\u00020\"H\u0002J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0005H\u0002J\f\u0010<\u001a\u00020\u0019*\u00020=H\u0002J\f\u0010>\u001a\u00020\u0003*\u00020?H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020\u0003H\u0002J\f\u0010B\u001a\u00020)*\u00020=H\u0002J\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020=H\u0002J\f\u0010E\u001a\u00020\u001d*\u00020\u0019H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0018j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006H"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter;", "conversationId", "", "lastChatTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "selectCallback", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$IFileSelectCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$IFileSelectCallback;)V", "Ljava/lang/Long;", "context", "Landroid/content/Context;", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "processor", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/data/ChatRecentFileLoadProcessor;", "isLoadingMore", "", "hasMore", "isFirstLoadPending", "recentItemsMap", "Ljava/util/LinkedHashMap;", "Lcom/larus/platform/api/FlowSelectedFileItem;", "Lkotlin/collections/LinkedHashMap;", "recentItemCreateTimeMap", "loadingFooterItem", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "scrollListener", "com/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$scrollListener$1", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$scrollListener$1;", "onAttachedToRecyclerView", "", "recyclerView", "onDetachedFromRecyclerView", "bindFileViewHolder", "holder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileViewHolder;", "position", "", "getItemViewType", "onCreateViewHolder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "notifyDisableStateChanged", "updateFileList", "createLoadProcessor", "loadMore", "shouldShowLoadingFooter", "buildSortedRecentList", "", "submitDataListWithFooter", "data", "scheduleLoadMoreIfListCannotScroll", "getFileVisitTimeString", "visitTime", "toSelectedFileItem", "Lcom/larus/drive/sdk/api/file/select/ChatRecentFileItem;", "toExtraValue", "Lcom/larus/drive/sdk/api/file/select/ChatRecentFileSource;", "recentFileIdentity", "uri", "resolveIconResId", "parseValidDriveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "toBaseFileSelectConfig", "Companion", "IFileSelectCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRecentFileSelectAdapter extends BaseFileSelectAdapter {
    public static final /* synthetic */ int p = 0;
    public final String b;
    public final Long c;
    public final CoroutineScope d;
    public final b e;
    public Context f;
    public RecyclerView g;
    public ChatRecentFileLoadProcessor h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final LinkedHashMap<String, u> l;
    public final LinkedHashMap<String, Long> m;
    public final x79.a n;
    public final ChatRecentFileSelectAdapter$scrollListener$1 o;

    public static final class a {
    }

    public interface b {
        IChatFileSelectionStore.a a(u r1);

        void b(boolean r1);

        void c(u r1, IChatFileSelectionStore.a r2);

        void d(u r1, boolean r2);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatRecentFileSource.values().length];
            r0[ChatRecentFileSource.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ChatRecentFileSource.DOUBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ChatRecentFileSource.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void D2() {
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.j == false) goto L15;
        this.i = true;
        if (this.k == false) goto L10;
    L12:
        BuildersKt.launch$default(this.d, null, null, new ChatRecentFileSelectAdapter$loadMore$1(this, null), 3, null);
        return;
    L10:
        if ((true ^ getCurrentList().isEmpty()) == false) goto L12;
        F2(getCurrentList());
        goto L12
    }

    public static final List B2(ChatRecentFileSelectAdapter r12) {
        Collection<u> r0 = r12.l.values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        u r3 = (u) r2.next();
        Intrinsics.checkNotNull(r3);
        String r4 = r3.a;
        String r5 = r3.b;
        String r6 = r3.d;
        int r7 = r3.e;
        if (r3.f != FlowDriveFileType.IMAGE) goto L8;
        boolean r8 = true;
    L9:
        r1.add(new x79.a(r4, r5, r6, r7, r8, BaseFileSelectFromType.RECENT, 48));
        goto L4
    L8:
        r8 = false;
        goto L9
    L11:
        return CollectionsKt.sortedWith(r1, new i(r12));
    }

    public static String E2(String r1) {
        String r2 = StringsKt.trim(StringsKt.removePrefix(r1, "imkey://")).toString();
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r2;
    L5:
        r0 = false;
        goto L6
    }

    public final void F2(List<x79.a> r5) {
        if (this.i == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L19;
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Object r2 = r6.next();
        if (Intrinsics.areEqual(((x79.a) r2).a, "__recent_load_more_footer__") == true) goto L14;
        r1.add(r2);
        goto L14
    L18:
        List<x79.a> r7 = CollectionsKt.plus(r1, this.n);
    L26:
        A2(r7);
        return;
    L19:
        ArrayList r3 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L25;
        Object r4 = r8.next();
        if (Intrinsics.areEqual(((x79.a) r4).a, "__recent_load_more_footer__") == true) goto L21;
        r3.add(r4);
        goto L21
    L25:
        r7 = r3;
        goto L26
    L5:
        if (this.j == false) goto L9;
        if (this.k == true) goto L9;
        r0 = true;
        goto L11
    }

    public final int getItemViewType(int r2) {
        if (Intrinsics.areEqual(((x79.a) getItem(r2)).a, "__recent_load_more_footer__") == false) goto L6;
        return BaseFileSelectAdapter.ViewType.LOADING_FOOTER.getId();
    L6:
        return BaseFileSelectAdapter.ViewType.FILE.getId();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        this.g = r2;
        if (this.f != null) goto L5;
        this.f = r2.getContext();
    L5:
        r2.addOnScrollListener(this.o);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        r3.removeOnScrollListener(this.o);
        if (this.g != r3) goto L5;
        this.g = null;
    L5:
        this.f = null;
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r3);
    }

    public static final u C2(ChatRecentFileSelectAdapter r18, x79.b r110) {
        String r0 = r110.g;
        if (r0 != null) goto L5;
    L40:
        DriveUplinkInfo r1 = null;
    L41:
        String r6 = r110.b;
        String r7 = r110.a;
        long r8 = r110.d;
        String r5 = m.a(r110.f);
        Context r10 = r18.f;
        if (r10 == null) goto L48;
        String r12 = r10.getString(2131905307);
        if (r12 == null) goto L48;
        String r11 = StringsKt.replace$default(r12, "%s", r5, false, 4, null);
        if (r11 == null) goto L48;
    L49:
        DriveFileType r9 = r110.e;
        DriveFileType r13 = DriveFileType.BITABLE;
        if (r9 != r13) goto L54;
        int r14 = bq9.b.a;
        if (bq9.b.a(r110.h, r110.c) == false) goto L54;
        h19.b r15 = h19.b.a;
        CommonFileIconType r16 = CommonFileIconType.BITABLE_APP;
        r15.getClass();
        int r17 = h19.b.a(r16);
    L55:
        int r111 = r17;
        a89.a r20 = com.larus.drive.sdk.impl.utils.h.a;
        FlowDriveFileType r112 = com.larus.drive.sdk.impl.utils.h.b(r110.e);
        String r113 = r110.c;
        DriveFileType r21 = r110.e;
        Intrinsics.checkNotNullParameter(r21, "fileType");
        switch(com.larus.drive.sdk.impl.utils.h.a.b[r21.ordinal()]) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            default: goto L57;
        };
    L57:
        int r114 = 12;
    L64:
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("originFileTypeString", r110.e.getValue());
        r22.put("originUrl", r110.c);
        r22.put("upload_way", "recent_sent_file");
        if (r1 == null) goto L67;
        String r2 = "drive";
    L68:
        r22.put("upload_from", r2);
        int r3 = c.a[r110.i.ordinal()];
        if (r3 != 1) goto L71;
        String r4 = "lark";
    L78:
        r22.put("recentFileSource", r4);
        Integer r23 = r110.h;
        if (r23 == null) goto L89;
        r23.intValue();
        if (r110.e != r13) goto L83;
        boolean r24 = true;
    L84:
        if (r24 == true) goto L87;
        r23 = null;
    L87:
        if (r23 == null) goto L89;
        String r25 = (String) r22.put("originBaseBizType", String.valueOf(r23.intValue()));
        goto L89
    L83:
        r24 = false;
    L89:
        if (r1 == null) goto L91;
        r22.put("drive_uplink_info", r1.toString());
    L91:
        Unit r26 = Unit.INSTANCE;
        return new u(r6, r7, r8, r11, r111, r112, r113, r114, r22, 3840);
    L71:
        if (r3 == 2) goto L76;
        if (r3 != 3) goto L75;
        r4 = "unknown";
        goto L78
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r4 = "doubao";
        goto L78
    L67:
        r2 = "local";
        goto L68
    L58:
        r114 = 0;
        goto L64
    L59:
        r114 = 11;
        goto L64
    L60:
        r114 = 8;
        goto L64
    L61:
        r114 = 3;
        goto L64
    L62:
        r114 = 30;
        goto L64
    L63:
        r114 = 22;
    L54:
        r17 = r110.e.getIconResId();
    L48:
        r11 = r5;
        goto L49
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L40;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L12
        Object r28 = Result.constructor-impl((DriveUplinkInfo) new Gson().fromJson(r0, DriveUplinkInfo.class));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r28) == false) goto L17;
        r28 = null;
    L17:
        r1 = (DriveUplinkInfo) r28;
        if (r1 == null) goto L40;
        String r30 = r1.getFileToken();
        if (r30 != null) goto L22;
    L25:
        boolean r31 = true;
    L26:
        if (r31 == false) goto L37;
        String r32 = r1.getUrl();
        if (r32 != null) goto L30;
    L33:
        boolean r33 = true;
    L34:
        if (r33 == false) goto L37;
        boolean r34 = false;
    L38:
        if (r34 == false) goto L40;
    L30:
        if (StringsKt.isBlank(r32) == true) goto L33;
        r33 = false;
    L37:
        r34 = true;
        goto L38
    L22:
        if (StringsKt.isBlank(r30) == true) goto L25;
        r31 = false;
    L12:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final void y2(BaseFileSelectAdapter.FileViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        x79.a r8 = (x79.a) getItem(r7);
        String r0 = E2(r8.a);
        final IChatFileSelectionStore.a r1 = null;
        if (r0 == null) goto L5;
        final u r2 = this.l.get(r0);
    L6:
        if (r2 == null) goto L10;
        b r3 = this.e;
        if (r3 == null) goto L10;
        r1 = r3.a(r2);
    L10:
        if (r1 == null) goto L12;
        final boolean r4 = true;
    L13:
        Intrinsics.checkNotNull(r8);
        r6.T3(r8, this.a.contains(r8.a), new h(r4, r2, this, r1));
        View r9 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r4 == false) goto L16;
        float r10 = 0.3f;
    L17:
        r9.setAlpha(r10);
        return;
    L16:
        r10 = 1.0f;
        goto L17
    L12:
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final BaseFileSelectAdapter.BaseViewHolder z2(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != BaseFileSelectAdapter.ViewType.LOADING_FOOTER.getId()) goto L6;
        return new BaseFileSelectAdapter.LoadMoreFooterViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131562515, r4, false));
    L6:
        return super.z2(r4, r5);
    }

    /* JADX WARN: Type inference failed for: r11v5, types: [com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter$scrollListener$1] */
    public ChatRecentFileSelectAdapter(String r9, Long r10, LifecycleCoroutineScope r11, com.larus.drive.sdk.impl.view.chat.fileselect.i r12) {
        Intrinsics.checkNotNullParameter(r11, "scope");
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.j = true;
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new x79.a("__recent_load_more_footer__", "", "", 0, false, BaseFileSelectFromType.LOCAL, 112);
        this.o = new ChatRecentFileSelectAdapter$scrollListener$1(this);
        if (r10 == null) goto L5;
        long r0 = r10.longValue();
    L6:
        this.h = new ChatRecentFileLoadProcessor(r9, r0);
        return;
    L5:
        r0 = System.currentTimeMillis();
        goto L6
    }
}
