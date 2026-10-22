package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "", "<init>", "()V", "toString", "", "Hide", "Show", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState$Hide;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState$Show;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class ShortcutViewState {

    public static final class a extends ShortcutViewState {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(null);
        }
    }

    public static final class b extends ShortcutViewState {
        public final Uri a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.ShortcutViewState
        public final String toString() {
            return "Show(uri=" + this.a + ')';
        }

        public b(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            super(null);
            this.a = r2;
        }
    }

    private ShortcutViewState() {
    }

    public /* synthetic */ ShortcutViewState(DefaultConstructorMarker r1) {
        this();
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
