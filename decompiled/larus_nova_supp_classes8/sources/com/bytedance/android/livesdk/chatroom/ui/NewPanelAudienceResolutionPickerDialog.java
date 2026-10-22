package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "ResolutionItemView", "a", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPanelAudienceResolutionPickerDialog extends CommonStandardBottomDialog {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.NewPanelAudienceResolutionPickerDialog$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class ResolutionItemView extends FrameLayout {
        public final Lazy a;
        public final Function1<String, Unit> b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.NewPanelAudienceResolutionPickerDialog$ResolutionItemView$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1);
            }

            public final void invoke(String r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                invoke((String) r1);
                return Unit.INSTANCE;
            }
        }

        public final TextView a() {
            return (TextView) this.a.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ResolutionItemView(final Context r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "selectedCallback");
            super(r3);
            this.b = r4;
            this.a = LazyKt.lazy(new NewPanelAudienceResolutionPickerDialog$ResolutionItemView$tv$2(r3));
            ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(-1, (int) fm3.e.a(r3, 32.0f));
            r5.bottomMargin = (int) fm3.e.a(r3, 15.0f);
            r5.leftMargin = (int) fm3.e.a(r3, 4.0f);
            r5.rightMargin = (int) fm3.e.a(r3, 4.0f);
            Unit r6 = Unit.INSTANCE;
            setLayoutParams(r5);
            addView(a());
        }
    }

    public static final class a extends RecyclerView.ViewHolder {
        public final ResolutionItemView a;

        public a(ResolutionItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "resolutionView");
            super(r2);
            this.a = r2;
        }
    }

    public final int getLayoutId() {
        return 2131565391;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        findViewById(2131379343).setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        findViewById(2131379343).setAdapter(new NewPanelAudienceResolutionPickerDialog$createAdapter$1(this));
    }
}
