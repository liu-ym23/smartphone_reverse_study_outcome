package com.larus.community.impl.component;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 implements com.larus.chat.gallery.api.i {
    public final gs9.e a;
    public final Function0<List<UserCreation>> b;

    public static final class a {
    }

    static {
    }

    public final List<UserCreation> a() {
        LiveData r0 = this.a.getFeedDataLiveData();
        if (r0 == null) goto L5;
        List r1 = (List) r0.getValue();
    L7:
        return f(g(r1), e());
    L5:
        r1 = null;
        goto L7
    }

    public final void b() {
        this.a.checkLoadMore();
    }

    public final LiveData<Integer> c() {
        LiveData r0 = this.a.getFeedDataLiveData();
        if (r0 != null) goto L7;
        return new MutableLiveData(Integer.valueOf(e().size()));
    L7:
        return Transformations.map(r0, new e0(this));
    }

    public final LiveData<Integer> d() {
        return Transformations.map(this.a.getMoreState(), new f0());
    }

    public final List<UserCreation> e() {
        Function0<List<UserCreation>> r0 = this.b;
        if (r0 == null) goto L5;
        List<UserCreation> r1 = (List) r0.invoke();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    public static List g(List r3) {
        if (r3 != null) goto L4;
        r3 = CollectionsKt.emptyList();
    L4:
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r1 = r4.next();
        if (fs9.a0.b((UserCreationModel) r1) == true) goto L6;
        r0.add(r1);
        goto L6
    L10:
        ArrayList r5 = new ArrayList();
        Iterator r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        List r6 = ((UserCreationModel) r2.next()).b();
        if (r6 != null) goto L16;
        r6 = CollectionsKt.emptyList();
    L16:
        CollectionsKt.addAll(r5, r6);
        goto L12
    L17:
        return r5;
    }

    public g0(CreationFeedViewModel r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
        this.b = r3;
    }

    public static List f(List r5, List r6) {
        if (((ArrayList) r5).isEmpty() == false) goto L10;
        if ((!r6.isEmpty()) == true) goto L44;
        return null;
    L44:
        return r6;
    L10:
        if (r6.isEmpty() == false) goto L12;
        return r5;
    L12:
        ArrayList r0 = new ArrayList();
        Iterator r2 = r5.iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        String r3 = ((UserCreation) r2.next()).a;
        if (r3 == null) goto L14;
        r0.add(r3);
        goto L14
    L18:
        HashSet r1 = CollectionsKt.toHashSet(r0);
        ArrayList r4 = new ArrayList();
        Iterator r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L30;
        Object r8 = r7.next();
        String r9 = ((UserCreation) r8).a;
        if (r9 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L20;
        r4.add(r8);
        goto L20
    L24:
        if ((!r1.contains(r9)) != true) goto L26;
        r10 = true;
        goto L27
    L30:
        if (r4.isEmpty() == false) goto L33;
        return r5;
    L33:
        return CollectionsKt.plus(r5, r4);
    }
}
