package cw8;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.larus.business.debug.base.DebugConstants$DebugTools$DebugToolsType;
import com.larus.business.debug.base.adapter.EntrancePageAdapter;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import com.larus.business.debug.base.view.DebugEntranceRecyclerLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class b {
    public final EntrancePage a;
    public final ViewGroup b;
    public final List<EntranceGroup> c;
    public final View d;
    public final RecyclerView e;
    public final EditText f;
    public final EntrancePageAdapter g;
    public final a h;

    public static final class a implements TextWatcher {
        public final /* synthetic */ b a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            if (r3 == null) goto L5;
            String r7 = r3.toString();
            if (r7 == null) goto L5;
        L6:
            EntrancePage r8 = this.a.a;
            k r9 = k.a;
            Intrinsics.checkNotNullParameter(r7, "newText");
            Intrinsics.checkNotNullParameter(r8, "page");
            int r10 = k.a.a[r8.ordinal()];
            boolean r11 = true;
            if (r10 != 1) goto L9;
            k.g = r7;
            k r12 = k.a;
            Map<EntranceGroup, LinkedList<e>> r13 = k.e;
            r12.getClass();
            Map r14 = k.b(r7, r13);
            if (r14.size() == ((EnumMap) k.i).size()) goto L21;
        L30:
            EnumMap r15 = (EnumMap) k.i;
            r15.putAll(r14);
            if (r11 == false) goto L33;
            r15.clear();
            r15.putAll(r14);
        L33:
            boolean r16 = r11;
        L34:
            if (r16 == false) goto L36;
            this.a.g.y2();
        L36:
            int r17 = xv8.a.a;
            xv8.a.a(DebugConstants$DebugTools$DebugToolsType.SEARCH, "search_input");
            return;
        L21:
            if (r14.isEmpty() == true) goto L30;
            Iterator r18 = ((LinkedHashMap) r14).keySet().iterator();
            boolean r19 = false;
        L25:
            if (r18.hasNext() == false) goto L29;
            EntranceGroup r0 = (EntranceGroup) r18.next();
            if (((EnumMap) k.i).keySet().contains(r0) == true) goto L25;
            r19 = true;
            goto L25
        L29:
            r11 = r19;
            goto L30
        L9:
            if (r10 == 2) goto L14;
            k r20 = k.a;
            List<Map<EntranceGroup, LinkedList<e>>> r21 = aw8.c.a;
            List<Map<EntranceGroup, LinkedList<e>>> r22 = aw8.c.e;
            r20.getClass();
            Pair r23 = k.a(r7, r21, r22);
            Intrinsics.checkNotNullParameter(r7, "searchText");
            Intrinsics.checkNotNullParameter(r23, "filterResult");
            aw8.c.d = r7;
            if (((Boolean) r23.getSecond()).booleanValue() == false) goto L13;
            ArrayList r24 = (ArrayList) r22;
            r24.clear();
            r24.addAll((Collection) r23.getFirst());
        L13:
            r16 = ((Boolean) r23.getSecond()).booleanValue();
            goto L34
        L14:
            k.h = r7;
            k r25 = k.a;
            List<Map<EntranceGroup, LinkedList<e>>> r26 = k.f;
            List<Map<EntranceGroup, LinkedList<e>>> r27 = k.j;
            r25.getClass();
            Pair r28 = k.a(r7, r26, r27);
            boolean r29 = ((Boolean) r28.getSecond()).booleanValue();
            if (r29 == false) goto L17;
            ArrayList r30 = (ArrayList) r27;
            r30.clear();
            r30.addAll((Collection) r28.getFirst());
        L17:
            r16 = r29;
        L5:
            r7 = "";
            goto L6
        }
    }

    public void c() {
        this.e.setAdapter(this.g);
        RecyclerView.ItemAnimator r0 = this.e.getItemAnimator();
        if (r0 == null) goto L5;
        r0.setChangeDuration(0);
    L5:
        SimpleItemAnimator r1 = this.e.getItemAnimator();
        if ((r1 instanceof SimpleItemAnimator) == false) goto L8;
        SimpleItemAnimator r2 = r1;
    L9:
        if (r2 == null) goto L11;
        r2.setSupportsChangeAnimations(false);
    L11:
        this.g.y2();
        this.e.setLayoutManager(new DebugEntranceRecyclerLinearLayoutManager(this.b.getContext()));
        EditText r3 = this.f;
        if (r3 == null) goto L15;
        r3.addTextChangedListener(this.h);
        return;
    L15:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public void d() {
        EditText r0 = this.f;
        if (r0 == null) goto L6;
        r0.removeTextChangedListener(this.h);
        return;
    }

    public b(EntrancePage r4, ViewGroup r5, List<EntranceGroup> r6) {
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r6, "entranceGroupList");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        View r7 = LayoutInflater.from(r5.getContext()).inflate(2131562017, r5, false);
        this.d = r7;
        this.e = r7.findViewById(2131368587);
        this.f = (EditText) r7.findViewById(2131368590);
        this.g = new EntrancePageAdapter(r6, r4);
        this.h = new a(this);
    }
}
