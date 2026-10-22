package com.bytedance.android.live.draggablecomponent;

import android.text.Spannable;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\tR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/LiveAnchorTeleprompterVm;", "Lcom/bytedance/live/datacontext/DataContext;", "", "initialize", "Lcom/bytedance/live/datacontext/n;", "Landroid/text/Spannable;", "foldTitle$delegate", "Lcom/bytedance/live/datacontext/p;", "getFoldTitle", "()Lcom/bytedance/live/datacontext/n;", "foldTitle", "title$delegate", "getTitle", "title", "content$delegate", "getContent", "content", "Lcom/bytedance/android/livesdk/message/model/InfoBoxBackGround;", "background$delegate", "getBackground", KtvSubElement.BACKGROUND, "Lcom/bytedance/live/datacontext/m;", "", "foldState$delegate", "getFoldState", "()Lcom/bytedance/live/datacontext/m;", "foldState", "<init>", "()V", "Companion", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorTeleprompterVm extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "LiveAnchorTeleprompterVm";
    private final p background$delegate;
    private final p content$delegate;
    private final p foldState$delegate;
    private final p foldTitle$delegate;
    private final p title$delegate;

    public static final class a {
        public static LiveAnchorTeleprompterVm a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(LiveAnchorTeleprompterVm.TAG);
            if ((r0 instanceof LiveAnchorTeleprompterVm) == true) goto L6;
            r0 = null;
        L6:
            return (LiveAnchorTeleprompterVm) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveAnchorTeleprompterVm.class, "foldTitle", "getFoldTitle()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LiveAnchorTeleprompterVm.class, "title", "getTitle()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LiveAnchorTeleprompterVm.class, "content", "getContent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LiveAnchorTeleprompterVm.class, KtvSubElement.BACKGROUND, "getBackground()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LiveAnchorTeleprompterVm.class, "foldState", "getFoldState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final n<InfoBoxBackGround> getBackground() {
        return (n) this.background$delegate.a(this, $$delegatedProperties[3]);
    }

    public final n<Spannable> getContent() {
        return (n) this.content$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getFoldState() {
        return (m) this.foldState$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<Spannable> getFoldTitle() {
        return (n) this.foldTitle$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<Spannable> getTitle() {
        return (n) this.title$delegate.a(this, $$delegatedProperties[1]);
    }

    public final void initialize() {
        com.bytedance.live.datacontext.b.a(this, TAG);
    }

    public LiveAnchorTeleprompterVm() {
        this.foldTitle$delegate = q.c(this);
        this.title$delegate = q.c(this);
        this.content$delegate = q.c(this);
        this.background$delegate = q.c(this);
        this.foldState$delegate = q.d(this, Boolean.TRUE);
    }
}
