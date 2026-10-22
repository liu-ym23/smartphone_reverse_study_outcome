package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0002)*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J0\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014R\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTag;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "colorSelected", "colorUnselected", EventBody.KEY_VALUE, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setSelected", "", BuildConfig.FLAVOR, "", "applyTextMetricFix", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "Style", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalTag extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f11119b;
    private final TextView c;
    private final int d;
    private final int e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTag$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Rect", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{Default, Rect};
        }

        static {
            Default = new Style("Default", 0);
            Rect = new Style("Rect", 1);
            Style[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        public static Style valueOf(String r2) {
            return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
        }

        public static Style[] values() {
            return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTag$Companion;", "", "<init>", "()V", "TAG", "", "tagAll", "getTagAll", "()Ljava/lang/String;", "tagFamily", "getTagFamily", "tagSocial", "getTagSocial", "tagHabit", "getTagHabit", "tagHobby", "getTagHobby", "tagPreferences", "getTagPreferences", "tagGoal", "getTagGoal", "tagPersoal", "getTagPersoal", "tagOthers", "getTagOthers", "originalPair", "", "", "getOriginalPair", "()Ljava/util/Map;", "portraitTags", "", "getPortraitTags", "()[Ljava/lang/String;", "specificTags", "getSpecificTags", "tags", "", "getTags", "()Ljava/util/List;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_all, TypedValues.Custom.S_STRING, "memory_personal_tag_all"));
        }

        public final String b() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_family, TypedValues.Custom.S_STRING, "memory_personal_tag_family"));
        }

        public final String c() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_social, TypedValues.Custom.S_STRING, "memory_personal_tag_social"));
        }

        public final String d() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_habit, TypedValues.Custom.S_STRING, "memory_personal_tag_habit"));
        }

        public final String e() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_hobby, TypedValues.Custom.S_STRING, "memory_personal_tag_hobby"));
        }

        public final String f() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_preferences, TypedValues.Custom.S_STRING, "memory_personal_tag_preferences"));
        }

        public final String g() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_goal, TypedValues.Custom.S_STRING, "memory_personal_tag_goal"));
        }

        public final String h() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_personal, TypedValues.Custom.S_STRING, "memory_personal_tag_personal"));
        }

        public final String i() {
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_others, TypedValues.Custom.S_STRING, "memory_personal_tag_others"));
        }

        public final Map<String, Integer> j() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_documents, TypedValues.Custom.S_STRING, "memory_personal_tag_documents")), Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS)), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_relationship, TypedValues.Custom.S_STRING, "memory_personal_tag_relationship")), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP)), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_address, TypedValues.Custom.S_STRING, "memory_personal_tag_address")), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS)), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_anniversary, TypedValues.Custom.S_STRING, "memory_personal_tag_anniversary")), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY))});
        }

        public final String[] k() {
            return new String[]{h(), f(), e(), d(), b(), c(), g(), com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_personal_tag_pain_points, TypedValues.Custom.S_STRING, "memory_personal_tag_pain_points"))};
        }

        public final String[] l() {
            SpreadBuilder r0 = new SpreadBuilder(2);
            r0.addSpread(((Collection) ZeusTransformUtils.preCheckCast(j().keySet(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]));
            r0.addSpread(k());
            return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11120a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.Default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Style.Rect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11120a = r0;
        }
    }

    static {
        f11118a = new a(null);
    }

    public PersonalTag(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PersonalTag(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public PersonalTag(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12, null, 8, null);
        View r15 = FrameLayout.inflate(r13, ZeusTransformUtils.mapRes(R.layout.item_memory_personal_tag, "layout", "item_memory_personal_tag"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.f11119b = r15;
        View r16 = r15.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, OaidModel.KEY_ID, "chip_text"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(...)");
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r16, TextView.class, "com.obric.memorydata.plugin");
        this.c = r17;
        this.d = r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_3, TypedValues.Custom.S_COLOR, "oui_basic_fill_element_3"));
        int r0 = r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, TypedValues.Custom.S_COLOR, "oui_basic_fill_element_2"));
        this.e = r0;
        TypedArray r18 = r13.obtainStyledAttributes(r14, R.styleable.PersonalTag);
        r17.setText(r18.getText(ZeusTransformUtils.mapRes(R.styleable.PersonalTag_text, "styleable", "PersonalTag_text")));
        int r3 = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.PersonalTag_text_color, "styleable", "PersonalTag_text_color"), -1);
        Style r4 = Style.values()[r18.getInt(ZeusTransformUtils.mapRes(R.styleable.PersonalTag_style, "styleable", "PersonalTag_style"), 0)];
        r18.recycle();
        setBackgroundColor(r0);
        r17.setTextColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b")));
        if (r3 == (-1)) goto L5;
        r17.setTextColor(r3);
    L5:
        a();
        int r19 = b.f11120a[r4.ordinal()];
        if (r19 != 1) goto L8;
        int r110 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_r_m2_rect, "dimen", "oui_r_m2_rect"));
    L13:
        setRadius(r110);
        setSelected(false);
        return;
    L8:
        if (r19 != 2) goto L11;
        r110 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ PersonalTag(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a() {
        this.c.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.c.setFallbackLineSpacing(false);
        return;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.c.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "getText(...)");
        return r1;
    }

    public final TextView getTextView() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r4) {
        RunLog.INSTANCE.debug("PortraitTag", "setSelected: " + r4 + ", current state: " + isSelected());
        if (r4 == isSelected()) goto L14;
        super.setSelected(r4);
        if (isSelected() == false) goto L7;
        int r5 = this.d;
    L8:
        setBackgroundColor(r5);
        if (isSelected() == false) goto L11;
        TextView r6 = this.c;
        int r1 = R.style.PersonalTagTextSelected;
        String r2 = "PersonalTagTextSelected";
    L12:
        r6.setTextAppearance(ZeusTransformUtils.mapRes(r1, "style", r2));
        a();
        return;
    L11:
        r6 = this.c;
        r1 = R.style.PersonalTagTextUnselected;
        r2 = "PersonalTagTextUnselected";
        goto L12
    L7:
        r5 = this.e;
        goto L8
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.c.setText(r4);
    }
}
