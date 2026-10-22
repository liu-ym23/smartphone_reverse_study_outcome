package com.lynx.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.event.EventsListener;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010 J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\n\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lr8a/a;", "Landroid/content/Context;", "context", "createView", NameKeys.UnloadStrategy_No_Strategy, "tag", NameKeys.UnloadStrategy_No_Strategy, "setTag", "getTag", NameKeys.UnloadStrategy_No_Strategy, "Lcom/lynx/tasm/event/EventsListener;", "events", "setEvents", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem$b;", "mPropChaneListener", "setPropChaneListener", NameKeys.UnloadStrategy_No_Strategy, LynxViewpagerItem.BIND_ON_ATTACH, NameKeys.UnloadStrategy_No_Strategy, "index", "sendIsAttachedEvent", "Ljava/lang/String;", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem$b;", "mEnableIsAttached", "Z", "Lcom/lynx/tasm/behavior/LynxContext;", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "Companion", "a", "b", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public class LynxViewpagerItem extends UIGroup<r8a.a> {
    public static final String BIND_ON_ATTACH = "attach";
    public static final a Companion = null;
    public static final String X_ELEMENT_TAG = "viewpager-item";
    private boolean mEnableIsAttached;
    private b mPropChaneListener;
    private String tag;

    public static final class a {
        public a() {
        }
    }

    public interface b {
    }

    static {
        Companion = new a();
    }

    public final void setPropChaneListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "mPropChaneListener");
    }

    public final String getTag() {
        return String.valueOf(this.tag);
    }

    public LynxViewpagerItem(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public r8a.a createView(Context r2) {
        return new r8a.a(r2, this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 == null) goto L6;
        this.mEnableIsAttached = r2.containsKey(BIND_ON_ATTACH);
        return;
    }

    @LynxProp(name = "tag")
    public final void setTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tag = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public LynxViewpagerItem(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final void sendIsAttachedEvent(boolean r5, int r6) {
        if (this.mEnableIsAttached == true) goto L5;
        return;
    L5:
        EventEmitter r0 = getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(getSign(), BIND_ON_ATTACH);
        r1.a(BIND_ON_ATTACH, Boolean.valueOf(r5));
        r1.a("tag", getTag());
        r1.a("index", Integer.valueOf(r6));
        r0.sendCustomEvent(r1);
    }
}
