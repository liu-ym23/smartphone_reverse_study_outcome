package com.ss.android.lark.piece.core;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\fH\u0017J\b\u0010\u000e\u001a\u00020\fH\u0017J\b\u0010\u000f\u001a\u00020\fH\u0017J\b\u0010\u0010\u001a\u00020\fH\u0017J\b\u0010\u0011\u001a\u00020\fH\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/piece/core/LifecycleOwnerPiece;", "T", "Lcom/ss/android/lark/piece/core/Piece;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "onCreate", "", "onStart", "onResume", "onPause", "onStop", "onDestroy", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "piece_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class LifecycleOwnerPiece<T> extends Piece<T> implements LifecycleOwner {
    public final LifecycleRegistry e;

    @Override // com.ss.android.lark.piece.core.Piece
    public void onCreate() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // com.ss.android.lark.piece.core.Piece
    public void onDestroy() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // com.ss.android.lark.piece.core.Piece
    public final void onPause() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.ss.android.lark.piece.core.Piece
    public final void onResume() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // com.ss.android.lark.piece.core.Piece
    public final void onStart() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // com.ss.android.lark.piece.core.Piece
    public final void onStop() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public LifecycleOwnerPiece() {
        this.e = new LifecycleRegistry(this);
    }

    public final Lifecycle getLifecycle() {
        return this.e;
    }
}
