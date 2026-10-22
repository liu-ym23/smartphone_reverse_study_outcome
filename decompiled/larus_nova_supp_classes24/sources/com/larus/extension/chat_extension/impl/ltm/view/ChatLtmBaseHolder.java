package com.larus.extension.chat_extension.impl.ltm.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.extension.chat_extension.impl.ltm.r;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindData", "", "data", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class ChatLtmBaseHolder extends RecyclerView.ViewHolder {

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder$Companion$ChatItemViewType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "TITLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ChatItemViewType extends Enum<ChatItemViewType> {
            public static final ChatItemViewType NORMAL = null;
            public static final ChatItemViewType TITLE = null;
            public static final /* synthetic */ ChatItemViewType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static EnumEntries<ChatItemViewType> getEntries() {
                return b;
            }

            static {
                ChatItemViewType r0 = new ChatItemViewType("NORMAL", 0, 0);
                NORMAL = r0;
                ChatItemViewType r1 = new ChatItemViewType("TITLE", 1, 1);
                TITLE = r1;
                ChatItemViewType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
            }

            public static ChatItemViewType[] values() {
                return (ChatItemViewType[]) a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChatItemViewType valueOf(String r1) {
                return (ChatItemViewType) a.a(ChatItemViewType.class, r1);
            }

            public ChatItemViewType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }
    }

    static {
    }

    public abstract void T3(r r1);

    public ChatLtmBaseHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
