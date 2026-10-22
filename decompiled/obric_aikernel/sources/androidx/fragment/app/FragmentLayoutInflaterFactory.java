package androidx.fragment.app;

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

/* JADX INFO: loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager r10) {
        this.mFragmentManager = r10;
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13) {
        if (FragmentContainerView.class.getName().equals(r11) == true) goto L5;
        Fragment r14 = null;
        if ("fragment".equals(r11) == true) goto L9;
        return null;
    L9:
        String r15 = r13.getAttributeValue(null, "class");
        TypedArray r16 = r12.obtainStyledAttributes(r13, R.styleable.Fragment);
        if (r15 != null) goto L12;
        r15 = r16.getString(R.styleable.Fragment_android_name);
    L12:
        int r17 = r16.getResourceId(R.styleable.Fragment_android_id, -1);
        String r18 = r16.getString(R.styleable.Fragment_android_tag);
        r16.recycle();
        if (r15 != null) goto L15;
    L62:
        return null;
    L15:
        if (FragmentFactory.isFragmentClass(r12.getClassLoader(), r15) == false) goto L62;
        if (r10 == null) goto L19;
        int r19 = r10.getId();
    L20:
        if (r19 != (-1)) goto L26;
        if (r17 != (-1)) goto L26;
        if (r18 != null) goto L26;
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r15);
    L26:
        if (r17 == (-1)) goto L28;
        r14 = this.mFragmentManager.findFragmentById(r17);
    L28:
        if (r14 != null) goto L31;
        if (r18 == null) goto L31;
        r14 = this.mFragmentManager.findFragmentByTag(r18);
    L31:
        if (r14 != null) goto L35;
        if (r19 == (-1)) goto L35;
        r14 = this.mFragmentManager.findFragmentById(r19);
    L35:
        if (r14 != null) goto L45;
        r14 = this.mFragmentManager.getFragmentFactory().instantiate(r12.getClassLoader(), r15);
        r14.mFromLayout = true;
        if (r17 == 0) goto L39;
        int r110 = r17;
    L40:
        r14.mFragmentId = r110;
        r14.mContainerId = r19;
        r14.mTag = r18;
        r14.mInLayout = true;
        FragmentManager r111 = this.mFragmentManager;
        r14.mFragmentManager = r111;
        r14.mHost = r111.getHost();
        r14.onInflate(this.mFragmentManager.getHost().getContext(), r13, r14.mSavedFragmentState);
        final FragmentStateManager r112 = this.mFragmentManager.addFragment(r14);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L49;
        StringBuilder r113 = new StringBuilder();
        r113.append("Fragment ");
        r113.append(r14);
        String r20 = " has been inflated via the <fragment> tag: id=0x";
    L43:
        r113.append(r20);
        r113.append(Integer.toHexString(r17));
        Log.v(TAG, r113.toString());
    L49:
        r14.mContainer = (ViewGroup) r10;
        r112.moveToExpectedState();
        r112.ensureInflatedView();
        View r21 = r14.mView;
        if (r21 == null) goto L59;
        if (r17 == 0) goto L54;
        r21.setId(r17);
    L54:
        if (r14.mView.getTag() != null) goto L56;
        r14.mView.setTag(r18);
    L56:
        r14.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, r112));
        return r14.mView;
    L59:
        throw new IllegalStateException("Fragment " + r15 + " did not create a view.");
    L39:
        r110 = r19;
        goto L40
    L45:
        if (r14.mInLayout == true) goto L61;
        r14.mInLayout = true;
        FragmentManager r114 = this.mFragmentManager;
        r14.mFragmentManager = r114;
        r14.mHost = r114.getHost();
        r14.onInflate(this.mFragmentManager.getHost().getContext(), r13, r14.mSavedFragmentState);
        r112 = this.mFragmentManager.createOrGetFragmentStateManager(r14);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L49;
        r113 = new StringBuilder();
        r113.append("Retained Fragment ");
        r113.append(r14);
        r20 = " has been re-attached via the <fragment> tag: id=0x";
        goto L43
    L61:
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r17) + ", tag " + r18 + ", or parent id 0x" + Integer.toHexString(r19) + " with another fragment for " + r15);
    L19:
        r19 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r12, r13, this.mFragmentManager);
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
        return onCreateView(null, r10, r11, r12);
    }
}
