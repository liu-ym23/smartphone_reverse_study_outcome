package com.larus.business.markdown.api.model;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.html.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bc\b\u0086\b\u0018\u00002\u00020\u0001B\u0098\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012'\b\u0002\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00106\u001a\u000207¢\u0006\u0002\u00108J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010?J\t\u0010v\u001a\u00020\u0011HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010?J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010TJ\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010TJ(\u0010}\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010!HÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010TJ\f\u0010\u0088\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010:J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010:J\n\u0010\u008d\u0001\u001a\u000207HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010TJ\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J£\u0003\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032'\b\u0002\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00106\u001a\u000207HÆ\u0001¢\u0006\u0003\u0010\u0095\u0001J\u0015\u0010\u0096\u0001\u001a\u00020\u000b2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0099\u0001\u001a\u00020\tHÖ\u0001R\u0015\u00104\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010F\u001a\u0004\bJ\u0010KR\u0019\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0015\u00103\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010;\u001a\u0004\bN\u0010:R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\u0015\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010TR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u0010MR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010U\u001a\u0004\bW\u0010TR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010KR\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010U\u001a\u0004\b[\u0010TR\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010KR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010U\u001a\u0004\b_\u0010TR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010KR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010U\u001a\u0004\be\u0010TR0\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0015\u00105\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010;\u001a\u0004\bj\u0010:R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u001c\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010F\u001a\u0004\bn\u0010oR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010@\u001a\u0004\bp\u0010?R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010R¨\u0006\u009a\u0001"}, d2 = {"Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "", "imgCornerRadius", "", "imgBgColor", "htmlTagHandlerList", "", "Lio/noties/markwon/html/TagHandler;", "codeCopyTitle", "", "enableCodeCopyButton", "", "useSubscribedColor", "linkColor", "codeTitleSize", "listItemColor", "blankLineMulti", "", "tableTextSize", "textLineMulti", "diffDp", "minImgWidthHeight", "bgListItemConfig", "Lcom/larus/business/markdown/api/model/BgListItemConfig;", "paragraphSpaceHeight", "listItemSpaceHeight", "paragraphSpaceHeightProvider", "Lkotlin/Function1;", "Lorg/commonmark/node/Node;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "node", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "thematicBreakConfig", "Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "codeBlockConfig", "Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "tableConfig", "Lcom/larus/business/markdown/api/model/TableConfig;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "listMarginInfo", "Lio/noties/markwon/core/spans/ListMarginInfo;", "customListPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "listConfig", "Lcom/larus/business/markdown/api/model/ListConfig;", "headingColor", "listStyle", "Lcom/larus/business/markdown/api/model/ListStyle;", "darkMode", "allowParentInterceptTouchWhenOverScroll", "splitCodeBlock", "latexSingleConfig", "Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/Integer;IILjava/lang/Float;FLjava/lang/Float;IILcom/larus/business/markdown/api/model/BgListItemConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;Lcom/larus/business/markdown/api/model/ThematicBreakConfig;Lcom/larus/business/markdown/api/model/CodeBlockConfig;Lcom/larus/business/markdown/api/model/TableConfig;Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lio/noties/markwon/core/spans/ListMarginInfo;Ljava/util/List;Lcom/larus/business/markdown/api/model/ListConfig;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/ListStyle;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;)V", "getAllowParentInterceptTouchWhenOverScroll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgListItemConfig", "()Lcom/larus/business/markdown/api/model/BgListItemConfig;", "getBlankLineMulti", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBlockQuoteConfig", "()Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "getCodeBlockConfig", "()Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "getCodeCopyTitle$annotations", "()V", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTitleSize$annotations", "getCodeTitleSize", "()I", "getCustomListPlugin", "()Ljava/util/List;", "getDarkMode", "getDiffDp", "getEnableCodeCopyButton$annotations", "getEnableCodeCopyButton", "()Z", "getHeadingColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHtmlTagHandlerList", "getImgBgColor", "getImgCornerRadius", "getLatexSingleConfig", "()Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "getLinkColor", "getListConfig", "()Lcom/larus/business/markdown/api/model/ListConfig;", "getListItemColor", "getListItemSpaceHeight", "getListMarginInfo", "()Lio/noties/markwon/core/spans/ListMarginInfo;", "getListStyle", "()Lcom/larus/business/markdown/api/model/ListStyle;", "getMinImgWidthHeight", "getParagraphSpaceHeight", "getParagraphSpaceHeightProvider", "()Lkotlin/jvm/functions/Function1;", "getPhoneNumberConfig", "()Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "getSplitCodeBlock", "getTableConfig", "()Lcom/larus/business/markdown/api/model/TableConfig;", "getTableTextSize$annotations", "getTableTextSize", "()F", "getTextLineMulti", "getThematicBreakConfig", "()Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "getUseSubscribedColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/Integer;IILjava/lang/Float;FLjava/lang/Float;IILcom/larus/business/markdown/api/model/BgListItemConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;Lcom/larus/business/markdown/api/model/ThematicBreakConfig;Lcom/larus/business/markdown/api/model/CodeBlockConfig;Lcom/larus/business/markdown/api/model/TableConfig;Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lio/noties/markwon/core/spans/ListMarginInfo;Ljava/util/List;Lcom/larus/business/markdown/api/model/ListConfig;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/ListStyle;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;)Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {
    private final Integer A;
    private final ListStyle B;
    private final Boolean C;
    private final Boolean D;
    private final Boolean E;
    private final com.larus.business.markdown.api.model.a.b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f5162b;
    private final List<u> c;
    private final String d;
    private final boolean e;
    private final boolean f;
    private final Integer g;
    private final int h;
    private final int i;
    private final Float j;
    private final float k;
    private final Float l;
    private final int m;
    private final int n;
    private final BgListItemConfig o;
    private final Integer p;
    private final Integer q;
    private final Function1<Node, Integer> r;
    private final a s;
    private final ThematicBreakConfig t;
    private final CodeBlockConfig u;
    private final TableConfig v;
    private final PhoneNumberConfig w;
    private final ListMarginInfo x;
    private final List<io.noties.markwon.a> y;
    private final f z;

    public c() {
        this(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null);
    }

    public c(int r9, Integer r10, List<? extends u> r11, String r12, boolean r13, boolean r14, Integer r15, int r16, int r17, Float r18, float r19, Float r20, int r21, int r22, BgListItemConfig r23, Integer r24, Integer r25, Function1<? super Node, Integer> r26, a r27, ThematicBreakConfig r28, CodeBlockConfig r29, TableConfig r30, PhoneNumberConfig r31, ListMarginInfo r32, List<? extends io.noties.markwon.a> r33, f r34, Integer r35, ListStyle r36, Boolean r37, Boolean r38, Boolean r39, com.larus.business.markdown.api.model.a.b r40) {
        List<u> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Function1<Node, Integer> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        List<io.noties.markwon.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "htmlTagHandlerList");
        Intrinsics.checkNotNullParameter(r12, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r40, "latexSingleConfig");
        this.f5161a = r9;
        this.f5162b = r10;
        this.c = r3;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.q = r25;
        this.r = r5;
        this.s = r27;
        this.t = r28;
        this.u = r29;
        this.v = r30;
        this.w = r31;
        this.x = r32;
        this.y = r4;
        this.z = r34;
        this.A = r35;
        this.B = r36;
        this.C = r37;
        this.D = r38;
        this.E = r39;
        this.F = r40;
    }

    public /* synthetic */ c(int r34, Integer r35, List r36, String r37, boolean r38, boolean r39, Integer r40, int r41, int r42, Float r43, float r44, Float r45, int r46, int r47, BgListItemConfig r48, Integer r49, Integer r50, Function1 r51, a r52, ThematicBreakConfig r53, CodeBlockConfig r54, TableConfig r55, PhoneNumberConfig r56, ListMarginInfo r57, List r58, f r59, Integer r60, ListStyle r61, Boolean r62, Boolean r63, Boolean r64, com.larus.business.markdown.api.model.a.b r65, int r66, DefaultConstructorMarker r67) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r51, Function1.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r58, List.class, "com.obric.memorydata.plugin");
        if ((r66 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r66 & 2) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r66 & 4) == 0) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        if ((r66 & 8) == 0) goto L16;
        String r9 = "";
    L18:
        if ((r66 & 16) == 0) goto L20;
        boolean r10 = true;
    L22:
        if ((r66 & 32) == 0) goto L24;
        boolean r11 = false;
    L26:
        if ((r66 & 64) == 0) goto L28;
        Integer r12 = null;
    L30:
        if ((r66 & 128) == 0) goto L32;
        int r13 = 0;
    L34:
        if ((r66 & 256) == 0) goto L36;
        int r14 = 0;
    L38:
        if ((r66 & 512) == 0) goto L40;
        Float r15 = null;
    L42:
        if ((r66 & 1024) == 0) goto L44;
        float r5 = 0.0f;
    L46:
        if ((r66 & 2048) == 0) goto L48;
        Float r8 = null;
    L50:
        if ((r66 & 4096) == 0) goto L52;
        int r6 = 0;
    L54:
        if ((r66 & 8192) == 0) goto L56;
        int r16 = 0;
    L58:
        if ((r66 & 16384) == 0) goto L60;
        BgListItemConfig r17 = null;
    L62:
        if ((r66 & 32768) == 0) goto L64;
        Integer r18 = null;
    L66:
        if ((r66 & 65536) == 0) goto L68;
        Integer r19 = null;
    L70:
        if ((r66 & 131072) == 0) goto L72;
        Function1 r110 = null;
    L74:
        if ((r66 & 262144) == 0) goto L76;
        a r111 = null;
    L78:
        if ((r66 & 524288) == 0) goto L80;
        ThematicBreakConfig r20 = null;
    L82:
        if ((r66 & 1048576) == 0) goto L84;
        CodeBlockConfig r21 = null;
    L86:
        if ((r66 & 2097152) == 0) goto L88;
        TableConfig r22 = null;
    L90:
        if ((r66 & 4194304) == 0) goto L92;
        PhoneNumberConfig r23 = null;
    L94:
        if ((r66 & 8388608) == 0) goto L96;
        ListMarginInfo r24 = null;
    L98:
        if ((r66 & 16777216) == 0) goto L100;
        List r25 = null;
    L102:
        if ((r66 & 33554432) == 0) goto L104;
        f r26 = null;
    L106:
        if ((r66 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L108;
        Integer r27 = null;
    L110:
        if ((r66 & 134217728) == 0) goto L112;
        ListStyle r28 = null;
    L114:
        if ((r66 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L116;
        Boolean r29 = null;
    L118:
        if ((r66 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L120;
        Boolean r30 = false;
    L122:
        if ((r66 & 1073741824) == 0) goto L124;
        Boolean r31 = false;
    L126:
        if ((r66 & Integer.MIN_VALUE) == 0) goto L128;
        com.larus.business.markdown.api.model.a.b r0 = new com.larus.business.markdown.api.model.a.b(0.0f, 0, 3, null);
    L129:
        this(r4, r7, r1, r9, r10, r11, r12, r13, r14, r15, r5, r8, r6, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r0);
        return;
    L128:
        r0 = r65;
        goto L129
    L124:
        r31 = r64;
        goto L126
    L120:
        r30 = r63;
        goto L122
    L116:
        r29 = r62;
        goto L118
    L112:
        r28 = r61;
        goto L114
    L108:
        r27 = r60;
        goto L110
    L104:
        r26 = r59;
        goto L106
    L100:
        r25 = r2;
        goto L102
    L96:
        r24 = r57;
        goto L98
    L92:
        r23 = r56;
        goto L94
    L88:
        r22 = r55;
        goto L90
    L84:
        r21 = r54;
        goto L86
    L80:
        r20 = r53;
        goto L82
    L76:
        r111 = r52;
        goto L78
    L72:
        r110 = r3;
        goto L74
    L68:
        r19 = r50;
        goto L70
    L64:
        r18 = r49;
        goto L66
    L60:
        r17 = r48;
        goto L62
    L56:
        r16 = r47;
        goto L58
    L52:
        r6 = r46;
        goto L54
    L48:
        r8 = r45;
        goto L50
    L44:
        r5 = r44;
        goto L46
    L40:
        r15 = r43;
        goto L42
    L36:
        r14 = r42;
        goto L38
    L32:
        r13 = r41;
        goto L34
    L28:
        r12 = r40;
        goto L30
    L24:
        r11 = r39;
        goto L26
    L20:
        r10 = r38;
        goto L22
    L16:
        r9 = r37;
        goto L18
    L9:
        r7 = r35;
        goto L11
    L5:
        r4 = r34;
        goto L7
    }

    public final Boolean A() {
        return this.E;
    }

    public final com.larus.business.markdown.api.model.a.b B() {
        return this.F;
    }

    public final int a() {
        return this.f5161a;
    }

    public final Integer b() {
        return this.f5162b;
    }

    public final List<u> c() {
        return this.c;
    }

    public final boolean d() {
        return this.f;
    }

    public final Integer e() {
        return this.g;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f5161a == r6.f5161a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5162b, r6.f5162b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Float.compare(this.k, r6.k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r6.E) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r6.F) == true) goto L104;
        return false;
    L104:
        return true;
    }

    public final int f() {
        return this.i;
    }

    public final Float g() {
        return this.j;
    }

    public final Float h() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.f5161a) * 31;
        Integer r1 = this.f5162b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        boolean r5 = this.e;
        ?? r6 = 1;
        ?? r7 = r5;
        if (r5 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.f;
        if (r9 == true) goto L13;
        r6 = r9;
    L13:
        int r10 = (r8 + r6) * 31;
        Integer r11 = this.g;
        if (r11 != null) goto L16;
        int r12 = 0;
    L17:
        int r13 = (((((r10 + r12) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
        Float r14 = this.j;
        if (r14 != null) goto L20;
        int r15 = 0;
    L21:
        int r16 = (((r13 + r15) * 31) + Float.hashCode(this.k)) * 31;
        Float r17 = this.l;
        if (r17 != null) goto L24;
        int r18 = 0;
    L25:
        int r19 = (((((r16 + r18) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n)) * 31;
        BgListItemConfig r20 = this.o;
        if (r20 != null) goto L28;
        int r21 = 0;
    L29:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.p;
        if (r23 != null) goto L32;
        int r24 = 0;
    L33:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.q;
        if (r26 != null) goto L36;
        int r27 = 0;
    L37:
        int r28 = (r25 + r27) * 31;
        Function1<Node, Integer> r29 = this.r;
        if (r29 != null) goto L40;
        int r30 = 0;
    L41:
        int r31 = (r28 + r30) * 31;
        a r32 = this.s;
        if (r32 != null) goto L44;
        int r33 = 0;
    L45:
        int r34 = (r31 + r33) * 31;
        ThematicBreakConfig r35 = this.t;
        if (r35 != null) goto L48;
        int r36 = 0;
    L49:
        int r37 = (r34 + r36) * 31;
        CodeBlockConfig r38 = this.u;
        if (r38 != null) goto L52;
        int r39 = 0;
    L53:
        int r40 = (r37 + r39) * 31;
        TableConfig r41 = this.v;
        if (r41 != null) goto L56;
        int r42 = 0;
    L57:
        int r43 = (r40 + r42) * 31;
        PhoneNumberConfig r44 = this.w;
        if (r44 != null) goto L60;
        int r45 = 0;
    L61:
        int r46 = (r43 + r45) * 31;
        ListMarginInfo r47 = this.x;
        if (r47 != null) goto L64;
        int r48 = 0;
    L65:
        int r49 = (r46 + r48) * 31;
        List<io.noties.markwon.a> r50 = this.y;
        if (r50 != null) goto L68;
        int r51 = 0;
    L69:
        int r52 = (r49 + r51) * 31;
        f r53 = this.z;
        if (r53 != null) goto L72;
        int r54 = 0;
    L73:
        int r55 = (r52 + r54) * 31;
        Integer r56 = this.A;
        if (r56 != null) goto L76;
        int r57 = 0;
    L77:
        int r58 = (r55 + r57) * 31;
        ListStyle r59 = this.B;
        if (r59 != null) goto L80;
        int r60 = 0;
    L81:
        int r61 = (r58 + r60) * 31;
        Boolean r62 = this.C;
        if (r62 != null) goto L84;
        int r63 = 0;
    L85:
        int r64 = (r61 + r63) * 31;
        Boolean r65 = this.D;
        if (r65 != null) goto L88;
        int r66 = 0;
    L89:
        int r67 = (r64 + r66) * 31;
        Boolean r68 = this.E;
        if (r68 == null) goto L94;
        r2 = r68.hashCode();
    L94:
        return ((r67 + r2) * 31) + this.F.hashCode();
    L88:
        r66 = r65.hashCode();
        goto L89
    L84:
        r63 = r62.hashCode();
        goto L85
    L80:
        r60 = r59.hashCode();
        goto L81
    L76:
        r57 = r56.hashCode();
        goto L77
    L72:
        r54 = r53.hashCode();
        goto L73
    L68:
        r51 = r50.hashCode();
        goto L69
    L64:
        r48 = r47.hashCode();
        goto L65
    L60:
        r45 = r44.hashCode();
        goto L61
    L56:
        r42 = r41.hashCode();
        goto L57
    L52:
        r39 = r38.hashCode();
        goto L53
    L48:
        r36 = r35.hashCode();
        goto L49
    L44:
        r33 = r32.hashCode();
        goto L45
    L40:
        r30 = r29.hashCode();
        goto L41
    L36:
        r27 = r26.hashCode();
        goto L37
    L32:
        r24 = r23.hashCode();
        goto L33
    L28:
        r21 = r20.hashCode();
        goto L29
    L24:
        r18 = r17.hashCode();
        goto L25
    L20:
        r15 = r14.hashCode();
        goto L21
    L16:
        r12 = r11.hashCode();
        goto L17
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final int i() {
        return this.m;
    }

    public final int j() {
        return this.n;
    }

    public final BgListItemConfig k() {
        return this.o;
    }

    public final Integer l() {
        return this.p;
    }

    public final Integer m() {
        return this.q;
    }

    public final Function1<Node, Integer> n() {
        return this.r;
    }

    public final a o() {
        return this.s;
    }

    public final ThematicBreakConfig p() {
        return this.t;
    }

    public final CodeBlockConfig q() {
        return this.u;
    }

    public final TableConfig r() {
        return this.v;
    }

    public final PhoneNumberConfig s() {
        return this.w;
    }

    public final ListMarginInfo t() {
        return this.x;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("CustomMarkDownInfo(imgCornerRadius=").append(this.f5161a).append(", imgBgColor=").append(this.f5162b).append(", htmlTagHandlerList=").append(this.c).append(", codeCopyTitle=").append(this.d).append(", enableCodeCopyButton=").append(this.e).append(", useSubscribedColor=").append(this.f).append(", linkColor=").append(this.g).append(", codeTitleSize=").append(this.h).append(", listItemColor=").append(this.i).append(", blankLineMulti=").append(this.j).append(", tableTextSize=").append(this.k).append(", textLineMulti=");
        r0.append(this.l).append(", diffDp=").append(this.m).append(", minImgWidthHeight=").append(this.n).append(", bgListItemConfig=").append(this.o).append(", paragraphSpaceHeight=").append(this.p).append(", listItemSpaceHeight=").append(this.q).append(", paragraphSpaceHeightProvider=").append(this.r).append(", blockQuoteConfig=").append(this.s).append(", thematicBreakConfig=").append(this.t).append(", codeBlockConfig=").append(this.u).append(", tableConfig=").append(this.v).append(", phoneNumberConfig=").append(this.w);
        r0.append(", listMarginInfo=").append(this.x).append(", customListPlugin=").append(this.y).append(", listConfig=").append(this.z).append(", headingColor=").append(this.A).append(", listStyle=").append(this.B).append(", darkMode=").append(this.C).append(", allowParentInterceptTouchWhenOverScroll=").append(this.D).append(", splitCodeBlock=").append(this.E).append(", latexSingleConfig=").append(this.F).append(')');
        return r0.toString();
    }

    public final List<io.noties.markwon.a> u() {
        return this.y;
    }

    public final f v() {
        return this.z;
    }

    public final Integer w() {
        return this.A;
    }

    public final ListStyle x() {
        return this.B;
    }

    public final Boolean y() {
        return this.C;
    }

    public final Boolean z() {
        return this.D;
    }
}
