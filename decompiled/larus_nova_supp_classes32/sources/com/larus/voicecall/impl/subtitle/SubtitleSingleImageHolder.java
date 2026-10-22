package com.larus.voicecall.impl.subtitle;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.databinding.LarusSubtitleHolderSingleImageBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleSingleImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemViewBinding", "Lcom/larus/voicecall/impl/databinding/LarusSubtitleHolderSingleImageBinding;", "uploadListener", "Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;", "ability", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusSubtitleHolderSingleImageBinding;Lcom/larus/voicecall/impl/subtitle/ISubtitleImageUploadListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;)V", LynxResourceModule.DATA_KEY, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "value", NameKeys.UnloadStrategy_No_Strategy, "isUploadImageErr", "()Z", "setUploadImageErr", "(Z)V", "bindData", NameKeys.UnloadStrategy_No_Strategy, "mobHolderShow", "onViewDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleSingleImageHolder extends RecyclerView.ViewHolder {
    public static final Set<String> f = null;
    public final LarusSubtitleHolderSingleImageBinding a;
    public final h b;
    public final f c;
    public c d;
    public boolean e;

    public static final class a {
    }

    static {
        f = new LinkedHashSet();
    }

    public final void T3() {
        c r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L7;
        x3a.a r3 = r1.i;
        if (r3 == null) goto L7;
        String r4 = r3.e;
    L8:
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 != null) goto L11;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        Set<String> r6 = f;
        if (r6.contains(r4) == false) goto L14;
        return;
    L14:
        if (StringsKt.isBlank(r4) == true) goto L42;
        r6.add(r4);
        String r7 = this.c.L();
        JSONObject r8 = new JSONObject();
        r8.put("if_call", 1);
        RealtimeCallParam r9 = this.c.d();
        if (r9 == null) goto L19;
        String r10 = r9.e;
    L20:
        r8.put("call_id", r10);
        RealtimeCallParam r11 = this.c.d();
        if (r11 == null) goto L23;
        String r12 = r11.d;
    L24:
        if (r12 == null) goto L27;
        r5 = r12;
    L27:
        r8.put("room_id", r5);
        RealtimeCallParam r13 = this.c.d();
        if (r13 == null) goto L32;
        RealtimeCallParam.k r14 = r13.p;
        if (r14 == null) goto L32;
        r2 = r14.i;
    L32:
        r8.put("call_enter_method", r2);
        r8.put("is_subtitles_mode", 1);
        r8.put("conversation_id", this.c.K());
        com.larus.voicecall.impl.scene.m r15 = this.c.a();
        if (r15 == null) goto L38;
        SceneModel r16 = r15.a;
        if (r16 == null) goto L38;
        String r17 = r16.getKey();
        if (r17 == null) goto L38;
    L39:
        r8.put("call_scene", r17);
        u2.c(r7, null, null, null, null, null, null, null, "user", null, null, null, null, r8, null, 114430);
        return;
    L38:
        r17 = "other";
        goto L39
    L23:
        r12 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L42:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void U3(boolean r2) {
        if (r2 == false) goto L4;
        com.larus.utils.e1.o(this.a.e);
        com.larus.utils.e1.o(this.a.c);
        com.larus.utils.e1.x(this.a.d);
    L5:
        this.e = r2;
        return;
    L4:
        com.larus.utils.e1.o(this.a.d);
        goto L5
    }

    public SubtitleSingleImageHolder(LarusSubtitleHolderSingleImageBinding r2, h r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "itemViewBinding");
        Intrinsics.checkNotNullParameter(r3, "uploadListener");
        Intrinsics.checkNotNullParameter(r4, "ability");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        com.larus.utils.e1.d(r2.d, new r1(this));
        com.larus.utils.e1.d(r2.b, new s1(this));
    }
}
