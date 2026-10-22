package androidx.fragment.app;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* JADX INFO: loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager r5) {
        this.mFragmentManager = r5;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r5, @NonNull Context r10, @NonNull AttributeSet r11) {
        return onCreateView(null, r5, r10, r11);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        if (FragmentContainerView.class.getName().equals(r11) == true) goto L5;
        Fragment r5 = null;
        if ("fragment".equals(r11) == true) goto L9;
        return null;
    L9:
        String r14 = r13.getAttributeValue(null, "class");
        TypedArray r15 = r12.obtainStyledAttributes(r13, R.styleable.Fragment);
        if (r14 != null) goto L12;
        r14 = r15.getString(R.styleable.Fragment_android_name);
    L12:
        int r16 = r15.getResourceId(R.styleable.Fragment_android_id, -1);
        String r17 = r15.getString(R.styleable.Fragment_android_tag);
        r15.recycle();
        if (r14 != null) goto L15;
    L61:
        return null;
    L15:
        if (FragmentFactory.isFragmentClass(r12.getClassLoader(), r14) == false) goto L61;
        if (r10 == null) goto L19;
        int r18 = r10.getId();
    L20:
        if (r18 != (-1)) goto L26;
        if (r16 != (-1)) goto L26;
        if (r17 != null) goto L26;
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r14);
    L26:
        if (r16 == (-1)) goto L28;
        r5 = this.mFragmentManager.findFragmentById(r16);
    L28:
        if (r5 != null) goto L31;
        if (r17 == null) goto L31;
        r5 = this.mFragmentManager.findFragmentByTag(r17);
    L31:
        if (r5 != null) goto L35;
        if (r18 == (-1)) goto L35;
        r5 = this.mFragmentManager.findFragmentById(r18);
    L35:
        if (r5 != null) goto L44;
        r5 = this.mFragmentManager.getFragmentFactory().instantiate(r12.getClassLoader(), r14);
        r5.mFromLayout = true;
        if (r16 == 0) goto L39;
        int r19 = r16;
    L40:
        r5.mFragmentId = r19;
        r5.mContainerId = r18;
        r5.mTag = r17;
        r5.mInLayout = true;
        FragmentManager r110 = this.mFragmentManager;
        r5.mFragmentManager = r110;
        r5.mHost = r110.getHost();
        r5.onInflate(this.mFragmentManager.getHost().getContext(), r13, r5.mSavedFragmentState);
        final FragmentStateManager r111 = this.mFragmentManager.addFragment(r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L48;
        Log.v("FragmentManager", "Fragment " + r5 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(r16));
    L48:
        ViewGroup r20 = (ViewGroup) r10;
        FragmentStrictMode.onFragmentTagUsage(r5, r20);
        r5.mContainer = r20;
        r111.moveToExpectedState();
        r111.ensureInflatedView();
        View r21 = r5.mView;
        if (r21 == null) goto L58;
        if (r16 == 0) goto L53;
        r21.setId(r16);
    L53:
        if (r5.mView.getTag() != null) goto L55;
        r5.mView.setTag(r17);
    L55:
        r5.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, r111));
        return r5.mView;
    L58:
        throw new IllegalStateException(j0.k("Fragment ", r14, " did not create a view."));
    L39:
        r19 = r18;
        goto L40
    L44:
        if (r5.mInLayout == true) goto L60;
        r5.mInLayout = true;
        FragmentManager r112 = this.mFragmentManager;
        r5.mFragmentManager = r112;
        r5.mHost = r112.getHost();
        r5.onInflate(this.mFragmentManager.getHost().getContext(), r13, r5.mSavedFragmentState);
        r111 = this.mFragmentManager.createOrGetFragmentStateManager(r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L48;
        Log.v("FragmentManager", "Retained Fragment " + r5 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(r16));
        goto L48
    L60:
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r16) + ", tag " + r17 + ", or parent id 0x" + Integer.toHexString(r18) + " with another fragment for " + r14);
    L19:
        r18 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r12, r13, this.mFragmentManager);
    }
}
