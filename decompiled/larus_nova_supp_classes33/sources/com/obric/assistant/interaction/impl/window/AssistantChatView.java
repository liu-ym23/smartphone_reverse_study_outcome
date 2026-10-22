package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\u00020\f*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0013H\u0014J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/AssistantChatView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasReportedFirstFrame", "", "fragmentContainer", "bindActivity", "", "activity", "Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity;", "bindActivity$impl_mainlandRelease", "bindWindowViewTreeOwners", "Landroid/view/View;", "getFragmentContainerId", "", "getFragmentContainerId$impl_mainlandRelease", "onAttachedToWindow", "onWindowVisibilityChanged", "visibility", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "registerFirstFrameCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantChatView extends FrameLayout {
    public static final Companion Companion = null;
    public static final String TAG = "AssistantChatView";
    private final FrameLayout fragmentContainer;
    private boolean hasReportedFirstFrame;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/AssistantChatView$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AssistantChatView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AttributeSet r0 = null;
        this(r3, r0, 2, r0);
    }

    private final void registerFirstFrameCallback() {
        if (this.hasReportedFirstFrame == false) goto L5;
        return;
    L5:
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == true) goto L8;
        return;
    L8:
        r0.addOnPreDrawListener(new AssistantChatView$registerFirstFrameCallback$listener$1(this));
    }

    public final int getFragmentContainerId$impl_mainlandRelease() {
        return this.fragmentContainer.getId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerFirstFrameCallback();
    }

    public static final /* synthetic */ boolean access$getHasReportedFirstFrame$p(AssistantChatView r0) {
        return r0.hasReportedFirstFrame;
    }

    public final void bindActivity$impl_mainlandRelease(ChatWindowActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        r2.bindContentRoot$impl_mainlandRelease(this);
        bindWindowViewTreeOwners(this, r2);
        bindWindowViewTreeOwners(r2.ensureDecorView(), r2);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        WindowHost.INSTANCE.onConfigurationChanged$impl_mainlandRelease(r2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    public AssistantChatView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        FrameLayout r4 = new FrameLayout(r2);
        r4.setId(2131373275);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fragmentContainer = r4;
        addView(r4);
    }

    public static final /* synthetic */ void access$setHasReportedFirstFrame$p(AssistantChatView r0, boolean r1) {
        r0.hasReportedFirstFrame = r1;
    }

    private final void bindWindowViewTreeOwners(View r2, ChatWindowActivity r3) {
        ViewTreeLifecycleOwner.set(r2, r3);
        ViewTreeViewModelStoreOwner.set(r2, r3);
        ViewTreeSavedStateRegistryOwner.set(r2, r3);
        r2.setTag(2131392608, r3);
    }

    public /* synthetic */ AssistantChatView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
