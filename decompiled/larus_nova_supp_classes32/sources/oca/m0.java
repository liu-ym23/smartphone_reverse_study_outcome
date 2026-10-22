package oca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemUserConfirmBinding;
import com.obric.assistant.card.databinding.ObricCardItemUserConfirmNegativeBinding;
import com.obric.assistant.card.databinding.ObricCardItemUserConfirmPostiveBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 extends b {
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    private final ObricCardItemUserConfirmBinding getBinding() {
        return (ObricCardItemUserConfirmBinding) this.x.getValue();
    }

    public m0(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.x = LazyKt.lazy(new k0(r2, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oca.b
    public final void o(final AppIntentMessage r10, final Message r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r11, "message");
        Map r0 = r10.getExt();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        String r1 = (String) r0.get("KEY_TITLE");
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r1 != null) goto L8;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        String r3 = (String) r0.get("KEY_CONTENT");
        if (r3 == null) goto L12;
        r2 = r3;
    L12:
        String r4 = (String) r0.get("KEY_OPTIONS");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L20
        if (o0.d(r4) == false) goto L18;
        JSONArray r7 = new JSONArray(r4);     // Catch: Throwable -> L20
        int r8 = r7.length();     // Catch: Throwable -> L20
        int r9 = 0;
    L16:
        if (r9 >= r8) goto L18;
        r6.add(JSONArrayProtectorUtils.getString(r7, r9));     // Catch: Throwable -> L20
        r9 = r9 + 1;     // Catch: Throwable -> L20
    L18:
        Object r12 = Result.constructor-impl(r6);     // Catch: Throwable -> L20
    L22:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L26;
        FLogger.a.w("UserConfirmEntityBox", "parse jsonArray error: " + r13, r13);
    L26:
        if (Result.exceptionOrNull-impl(r12) == null) goto L29;
        r12 = CollectionsKt.emptyList();
    L29:
        List r14 = (List) r12;
        getBinding().d.setText(StringsKt.trim(r1).toString());
        getBinding().c.setText(StringsKt.trim(r2).toString());
        getBinding().b.removeAllViews();
        Iterator r15 = r14.iterator();
        int r16 = 0;
    L31:
        if (r15.hasNext() == false) goto L55;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        final String r19 = (String) r17;
        if (r16 != CollectionsKt.getLastIndex(r14)) goto L43;
        if (r16 == 0) goto L43;
        LayoutInflater r20 = LayoutInflater.from(getContext());
        LinearLayout r21 = getBinding().b;
        RoundTextView r22 = r20.inflate(2131563966, r21, false);
        r21.addView(r22);
        if (r22 == null) goto L42;
        ViewBinding r23 = new ObricCardItemUserConfirmNegativeBinding(r22);
        Intrinsics.checkNotNull(r23);
    L46:
        View r24 = r23.getRoot();
        if ((r24 instanceof TextView) == false) goto L49;
        TextView r25 = (TextView) r24;
    L50:
        if (r25 == null) goto L52;
        r25.setText(r19);
    L52:
        r23.getRoot().setOnClickListener(new l0(this, r11, r10, r19));
        r16 = r18;
        goto L31
    L49:
        r25 = null;
        goto L50
    L42:
        throw new NullPointerException("rootView");
    L43:
        LayoutInflater r26 = LayoutInflater.from(getContext());
        LinearLayout r27 = getBinding().b;
        RoundTextView r28 = r26.inflate(2131563967, r27, false);
        r27.addView(r28);
        if (r28 == null) goto L54;
        r23 = new ObricCardItemUserConfirmPostiveBinding(r28);
        Intrinsics.checkNotNull(r23);
        goto L46
    L54:
        throw new NullPointerException("rootView");
    L55:
        return;
    L20:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
