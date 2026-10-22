package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.cae.location.database.StarLocationDbManager;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class s implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f2046a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f2047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f2048b;

        public a(s r8, x r10) {
            this.f2048b = r8;
            this.f2047a = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
            x r10 = this.f2047a;
            Fragment r11 = r10.f2060c;
            r10.k();
            i0.f((ViewGroup) r11.mView.getParent(), this.f2048b.f2046a).e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
        }
    }

    public s(FragmentManager r8) {
        this.f2046a = r8;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r17, String r18, Context r19, AttributeSet r20) {
        boolean r8 = FragmentContainerView.class.getName().equals(r18);
        FragmentManager r10 = this.f2046a;
        if (r8 == false) goto L7;
        return new FragmentContainerView(r19, r20, r10);
    L7:
        if ("fragment".equals(r18) == true) goto L9;
        return null;
    L9:
        String r11 = r20.getAttributeValue(null, StarLocationDbManager.GeofenceCallbackEntry.CLASS_NAME);
        TypedArray r12 = r19.obtainStyledAttributes(r20, r0.a.f11307a);
        int r13 = 0;
        if (r11 != null) goto L12;
        r11 = r12.getString(0);
    L12:
        int r14 = r12.getResourceId(1, -1);
        String r15 = r12.getString(2);
        r12.recycle();
        if (r11 != null) goto L82;
    L81:
        return null;
    L82:
        boolean r16 = Fragment.class.isAssignableFrom(q.a(r19.getClassLoader(), r11));     // Catch: ClassNotFoundException -> L17
    L18:
        if (r16 == false) goto L81;
        if (r17 == null) goto L22;
        r13 = r17.getId();
    L22:
        if (r13 != (-1)) goto L28;
        if (r14 != (-1)) goto L28;
        if (r15 != null) goto L28;
        throw new IllegalArgumentException(r20.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r11);
    L28:
        if (r14 == (-1)) goto L30;
        Fragment r21 = r10.B(r14);
    L31:
        if (r21 != null) goto L50;
        if (r15 == null) goto L50;
        y r22 = r10.f1864c;
        ArrayList<Fragment> r110 = r22.f2064a;
        int r111 = r110.size();
    L34:
        r111 = r111 - 1;
        if (r111 < 0) goto L41;
        Fragment r112 = r110.get(r111);
        if (r112 == null) goto L34;
        if (r15.equals(r112.mTag) == false) goto L34;
        r21 = r112;
        goto L50
    L41:
        Iterator<x> r23 = r22.f2065b.values().iterator();
    L43:
        if (r23.hasNext() == false) goto L49;
        x r113 = r23.next();
        if (r113 == null) goto L43;
        Fragment r114 = r113.f2060c;
        if (r15.equals(r114.mTag) == false) goto L43;
        r21 = r114;
        goto L50
    L49:
        r21 = null;
    L50:
        if (r21 != null) goto L54;
        if (r13 == (-1)) goto L54;
        r21 = r10.B(r13);
    L54:
        if (r21 != null) goto L63;
        q r24 = r10.D();
        r19.getClassLoader();
        r21 = Fragment.instantiate(((FragmentManager.e) r24).f1893b.f1877p.f2043b, r11, null);
        r21.mFromLayout = true;
        if (r14 == 0) goto L58;
        int r25 = r14;
    L59:
        r21.mFragmentId = r25;
        r21.mContainerId = r13;
        r21.mTag = r15;
        r21.mInLayout = true;
        r21.mFragmentManager = r10;
        r<?> r26 = r10.f1877p;
        r21.mHost = r26;
        r21.onInflate(r26.f2043b, r20, r21.mSavedFragmentState);
        x r27 = r10.a(r21);
        if (FragmentManager.G(2) == false) goto L68;
        StringBuilder r28 = new StringBuilder("Fragment ");
        r28.append(r21);
        String r29 = " has been inflated via the <fragment> tag: id=0x";
    L67:
        r28.append(r29);
        r28.append(Integer.toHexString(r14));
        Log.v("FragmentManager", r28.toString());
    L68:
        r21.mContainer = (ViewGroup) r17;
        r27.k();
        r27.j();
        View r30 = r21.mView;
        if (r30 == null) goto L78;
        if (r14 == 0) goto L73;
        r30.setId(r14);
    L73:
        if (r21.mView.getTag() != null) goto L75;
        r21.mView.setTag(r15);
    L75:
        r21.mView.addOnAttachStateChangeListener(new a(this, r27));
        return r21.mView;
    L78:
        throw new IllegalStateException(defpackage.b.d("Fragment ", r11, " did not create a view."));
    L58:
        r25 = r13;
        goto L59
    L63:
        if (r21.mInLayout == true) goto L80;
        r21.mInLayout = true;
        r21.mFragmentManager = r10;
        r<?> r31 = r10.f1877p;
        r21.mHost = r31;
        r21.onInflate(r31.f2043b, r20, r21.mSavedFragmentState);
        r27 = r10.g(r21);
        if (FragmentManager.G(2) == false) goto L68;
        r28 = new StringBuilder("Retained Fragment ");
        r28.append(r21);
        r29 = " has been re-attached via the <fragment> tag: id=0x";
        goto L67
    L80:
        throw new IllegalArgumentException(r20.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r14) + ", tag " + r15 + ", or parent id 0x" + Integer.toHexString(r13) + " with another fragment for " + r11);
    L30:
        r21 = null;
    L17:
        r16 = false;
        goto L18
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String r8, Context r10, AttributeSet r11) {
        return onCreateView(null, r8, r10, r11);
    }
}
