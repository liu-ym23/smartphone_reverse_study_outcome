package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007J\u0018\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fR\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/ChatTabPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "spec", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec;", "updateData", BuildConfig.FLAVOR, "getItemId", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "containsItem", BuildConfig.FLAVOR, "itemId", "getItemCount", "createFragment", "getCurrentTabSpecs", "getItem", "getTabPosition", "id", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTabPageAdapter extends FragmentStateAdapter {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.ChatTabPageAdapter$containsItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec;", "invoke", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec;)Ljava/lang/Long;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<b<?, ?>, Long> {
        final /* synthetic */ long $itemId;

        public AnonymousClass2(long r1) {
            this.$itemId = r1;
            super(1);
        }

        public final Long invoke(b<?, ?> r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            return Long.valueOf(this.$itemId);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((b) r1);
        }
    }

    static {
    }

    public final int getItemCount() {
        throw null;
    }

    public final boolean containsItem(long r2) {
        ChatTabPageAdapter$containsItem$transform$1 r3 = ChatTabPageAdapter$containsItem$transform$1.INSTANCE;
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    }

    public final Fragment createFragment(int r2) {
        if (r2 < 0) goto L6;
        throw null;
    L6:
        throw new IllegalStateException("fatal: create fragment error for position invalid");
    }

    public final long getItemId(int r3) {
        return ((b) ListProtector.get(null, r3)).getTabId();
    }
}
